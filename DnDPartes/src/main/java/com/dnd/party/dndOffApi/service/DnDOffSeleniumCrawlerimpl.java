package com.dnd.party.dndOffApi.service;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnd.party.search.dao.CharacterDAO;
import com.dnd.party.search.vo.CharacterVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DnDOffSeleniumCrawlerimpl implements DnDOffSeleniumCrawler {

	@Autowired
	CharacterDAO characterDAO;

	// WebDriver
	private WebDriver driver;
	private WebElement element;
	private String url;

	// Properties
	public static String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static String WEB_DRIVER_PATH = "src/main/resources/selenium/chromedriver.exe";

	// option
	final String buff = "B";
	final String synage = "S";
	final String dealer = "D";

	private String job = "헤카테";

	public void SeleniumSetting() {
		// System Property SetUp
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

		// Driver SetUp
		ChromeOptions options = new ChromeOptions();
		options.setCapability("ignoreProtectedModeSettings", true);
		driver = new ChromeDriver(options);
	}

	public void getData(CharacterVO cvo) throws InterruptedException {
		// get방식으로 url 요청
		url = "https://dunfaoff.com/SearchResult.df?server=" + cvo.getServerId() + "&characterid=" + cvo.getApiId();
		driver.get(url);
		
		// log.info("케릭터 url 호출 : " + cvo.getName());
		if (cvo.getType().equals(dealer) || cvo.getType().equals(synage)) {
			try {
				driver.findElements(By.id("damage_side")).get(0).click();
			} catch (Exception e) {
				driver.findElements(By.id("damage")).get(0).click();
			}
			
			Thread.sleep(100);
			// 시로코 1시 데미지 출력
			element = driver.findElement(By.id("skill_damage"));
			element.findElements(By.className("nav-item")).get(3).click();
			Thread.sleep(100);
			element.findElement(By.className("sinergeViewWrap")).findElements(By.className("btn-info")).get(1).click();

			List<WebElement> wel = element.findElements(By.className("dmgTable"));
			WebElement el = wel.get(wel.size() - 2);
			String damageSiroco = el.findElement(By.className("dmgRow")).getText().replace(",", "");

			// log.info("데미지 : " + damageSiroco);
			// 데미지 만단위만 처리
			damageSiroco = damageSiroco.substring(0, damageSiroco.length()-4);
			
			// log.info("데미지 : " + damageSiroco);
			cvo.setDamageSiroco(Long.parseLong(damageSiroco));
			cvo.setDamage(Long.parseLong(damageSiroco));
		} else if (cvo.getType().equals(buff)) {
			try {
				driver.findElements(By.id("holy_buff_side")).get(0).click();
			} catch (Exception e) {
				driver.findElements(By.id("holy_buff")).get(0).click();
			}
			
			Thread.sleep(100);
			// 괄호버프력, 총버프력
			element = driver.findElement(By.className("holyBuffTable"));
			List<WebElement> wel = element.findElements(By.className("buffRow"));

			WebElement el = wel.get(wel.size() - 1);
			// 총 버프력
			String buff = el.findElement(By.tagName("div")).getText().replace(",", "");

			// 아리아 버프력
			el = wel.get(wel.size() - 2);
			String buffAria = el.findElement(By.tagName("div")).getText();
			if (job.equals(cvo.getJob())) { // 헤카테 편애+퍼펫 버프력만 채용
				int startIdx = buffAria.indexOf("(퍼펫x편애)");
				int endIdx = buffAria.length();

				buffAria = buffAria.substring(startIdx + 8, endIdx).replace(",", "");

			} else {
				if (buffAria.contains("(") && buffAria.contains(")")) {
					int startIdx = buffAria.indexOf("(");
					int endIdx = buffAria.indexOf(")");

					buffAria = buffAria.substring(startIdx + 1, endIdx).replace(",", "");
				}
			}

			// log.info("버프력 : " + buffAria);
			// log.info("총 버프력 : " + buff);
			cvo.setBuff(Double.parseDouble(buff));
			cvo.setBuffAria(Double.parseDouble(buffAria));
		}

		// characterDAO.insertCharacterDetailHist(cvo);
		characterDAO.saveCharacterDetail(cvo);

	}

	@Override
	public List<HashMap<String, String>> getData() {
		long start = System.currentTimeMillis();

		SeleniumSetting();
		CharacterVO param = new CharacterVO();
		List<CharacterVO> clist = characterDAO.selectCharacters(param);

		for (CharacterVO cvo : clist) {
			try {
				getData(cvo);
			} catch (Exception e) {
				log.info(e.getMessage());
			}
		}
		
		driver.close();
		
		long end = System.currentTimeMillis();

		log.info("[DnDoffSeleniumCrawlerImpl] getData 실행 시간 : " + ( end - start )/1000.0 );

		return null;
	}

}
