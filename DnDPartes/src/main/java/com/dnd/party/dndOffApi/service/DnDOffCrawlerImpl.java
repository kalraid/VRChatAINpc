package com.dnd.party.dndOffApi.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.dnd.party.dndapi.api.NeopleRest;
import com.dnd.party.search.dao.CharacterDAO;
import com.dnd.party.search.service.CharacterService;
import com.dnd.party.search.vo.CharacterVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DnDOffCrawlerImpl implements DnDOffCrawler {

	@Autowired
	RestTemplate template;

	@Autowired
	CharacterService characterService;

	@Autowired
	CharacterDAO characterDAO;

	@Autowired
	NeopleRest neopleRest;

	public void SaveData(List<HashMap<String, String>> list) {
		list.forEach(o -> {
			CharacterVO cvo = new CharacterVO();
			cvo.setId(o.get("characterId"));
			if ("B".equals(o.get("type"))) {
				cvo.setBuff(Double.parseDouble(o.get("buffAria")) / 10000);
				cvo.setBuffAria(Double.parseDouble(o.get("buff")) / 10000);
				cvo.setDamageSendbag(0);
				cvo.setDamageSiroco(0);
			} else {

				cvo.setBuff(0);
				cvo.setBuffAria(0);
				cvo.setDamageSendbag(Long.parseLong(o.get("damageSendBag")) / 10000);
				cvo.setDamageSiroco(Long.parseLong(o.get("damageSiroco")) / 10000);
				cvo.setDamage(Long.parseLong(o.get("damageSiroco")) / 10000);
			}

			characterDAO.insertCharacterDetailHist(cvo);
			characterDAO.saveCharacterDetail(cvo);
		});

	}

	public List<HashMap<String, String>> getData() throws IOException {

		CharacterVO param = new CharacterVO();

		List<CharacterVO> list = characterService.selectCharacters(param);
		List<HashMap<String, String>> characterList = new ArrayList<>();

		for (CharacterVO characterVO : list) {
			HashMap<String, String> charaterInfo = new HashMap<>();
			String name = characterVO.getName();
			String id = characterVO.getApiId();

			ResponseEntity<?> response = neopleRest.getCharacterBaseInfo(name);
			HashMap<String, Object> body = (HashMap<String, Object>) response.getBody();

			List list1 = (List) body.get("rows");
			HashMap<String, String> listBody = (HashMap<String, String>) list1.get(0);
			param.setApiId(listBody.get("characterId"));
			param.setName(name);
			characterDAO.saveCharacterApiId(param);

			charaterInfo.put("characterId", characterVO.getId());
			charaterInfo.put("name", name);
			charaterInfo.put("type", characterVO.getType());

			if (!StringUtils.isEmpty(name) && !StringUtils.isEmpty(id)) {

				String url = "https://dundam.xyz/view.jsp?server=bakal&name=" + name + "&image=" + id;
				Document doc = Jsoup.connect(url).timeout(10000).validateTLSCertificates(false).get();

				if ("B".equals(characterVO.getType())) {
					try {

						int trCount = 0;
						if (characterVO.getJob().equals("헤카테") || characterVO.getJob().equals("홀리")) {
							trCount = 5;
						} else {
							trCount = 4;
						}

						Elements buffRows = doc.select("#buffTable");
						Element buffRow = buffRows.select("table").select("tr").get(trCount).select("td").get(0);
						String buff = buffRow.html();
						String buffAria = "";
						if (buff.contains("(") && buff.contains(")")) {
							int startIdx = buff.indexOf("(");
							int endIdx = buff.indexOf(")");

							buffAria = buff.substring(startIdx + 1, endIdx).replace(",", "");
							log.info(name + "의 버퍼력(괄호안) " + buffAria);

							buff = buff.substring(0, startIdx - 1).replace(",", "");
							log.info(name + "의 바퍼력 " + buff);
						}

						charaterInfo.put("buff", buff);
						charaterInfo.put("buffAria", buffAria);
					} catch (Exception e) {
						log.info("홀리가 딜세팅이면 버프력 세팅을 찾을수 없어서 buffRow 단계에서 에러 발생하므로 해당 케릭은 최신화 스킵");
						charaterInfo.put("buff", ""+characterVO.getBuff());
						charaterInfo.put("buffAria", ""+characterVO.getBuff());
					}

				} else {

					Elements damage1 = doc.select("#sendbag").select("table").select("tr");
					Element damage0 = damage1.get(damage1.size() - 3).select("td").get(0);
					long sendbagDamage = Long.parseLong(damage0.html().replace(",", ""));
					charaterInfo.put("damageSendBag", sendbagDamage + "");
					log.info(name + "의 샌드백 데미지는 " + sendbagDamage);

					Elements damage4 = doc.select("#siroco").select("table").select("tr");
					Element damage3 = damage4.get(damage1.size() - 3).select("td").get(1);

					long sirocoDamage = Long.parseLong(damage3.html().replace(",", ""));
					charaterInfo.put("damageSiroco", sirocoDamage + "");
					log.info(name + "의 시로코 데미지는 " + sirocoDamage);

				}

				characterList.add(charaterInfo);
			}
		}

		SaveData(characterList);

		return characterList;
	}

}
