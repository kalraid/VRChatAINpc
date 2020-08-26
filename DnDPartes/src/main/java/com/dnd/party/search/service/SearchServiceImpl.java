package com.dnd.party.search.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnd.party.search.dao.CharacterDAO;
import com.dnd.party.search.vo.CharacterVO;
import com.dnd.party.search.vo.SearchCheckVO;
import com.dnd.party.search.vo.UserVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SearchServiceImpl implements SearchService {

	@Autowired
	public CharacterDAO characterDAO;

	final String buff = "B";
	final String synage = "S";
	final String dealer = "D";

	final int superPower = 1500;
	final int power = 1000;

	final int superPowerLevel = 1;
	final int powerLevel = 2;

	@Override
	public List<List<CharacterVO>> selectParty(HashMap<String, Object> param) {
		String searchType = (String) param.get("type");
		List<List<CharacterVO>> party = new ArrayList();
		SearchCheckVO scvo = new SearchCheckVO();

		List<UserVO> users = (List<UserVO>) param.get("users");
		String selected = (String) param.get("selected");

		if (users.size() < 4) { // 4명 미만 검색시 null값으로 리턴
			return party;
		}

		scvo.setSelected(selected);
		scvo.setUsers(users);

		// 제약조건 : 1. 같은사람끼리는 안됨. 2. 버퍼하나 쩔딜러 하나씩은 필수 3. 3인자리에 시너지 하나 필수 4. 쩔러와 동일한 시너지케는
		// 안됨 5. 다녀온 케릭도 안됨
		// 6. 쩔딜 딜순 + 버퍼 역순 짠 뒤에 시너지를 붙여준다. 7. 버퍼수와 쩔딜러수를 체크후 적은것 기준으로 바티개수 측정

		List<CharacterVO> buffList = characterDAO.getBuffList(scvo);
		List<CharacterVO> dealerlist = characterDAO.getDealarList(scvo);
		List<CharacterVO> synagelist = characterDAO.getSynageList(scvo);
		List<CharacterVO> powerDealerList = characterDAO.getPowerDealerList(scvo);
		List<CharacterVO> leftPowerDealerList = new ArrayList();

		int endIdx = 1;
		int idx = 0;

		endIdx = buffList.size();
		if (buffList.size() <= powerDealerList.size()) { // 버퍼가 적은 경우

			for (CharacterVO cvo : buffList) {
				List<CharacterVO> partyMember = new ArrayList();
				partyMember.add(cvo);
				party.add(partyMember);
			}

			
			for (List<CharacterVO> plist : party) {
				for (CharacterVO cvo : powerDealerList) {
					if(!plist.get(0).getUserAlias().equals(cvo.getUserAlias())&&!cvo.getPartcipate()){
						cvo.setPartcipate(true);
						plist.add(cvo);
						break;
					}
							
				}
			}
			
			for (CharacterVO cvo : powerDealerList) {
				if(!cvo.getPartcipate()) {
					leftPowerDealerList.add(cvo);
				}
			}
			
			// party를 반대로 뒤집음 시너지 입력 용도
			Collections.reverse(party);
		} else { // 딜러가 적은 경우

			for (CharacterVO cvo : powerDealerList) {
				List<CharacterVO> partyMember = new ArrayList();
				partyMember.add(cvo);
				party.add(partyMember);
			}

			// 버퍼를 강한순서대로 약한 쩔딜파티에 넣기위해서
			Collections.reverse(party);
			Collections.reverse(buffList);

			for (CharacterVO cvo : buffList) {
				if (!party.get(idx).get(0).getUserId().equals(cvo.getUserId())) {
					party.get(idx).add(cvo);
					idx++;
					if (party.size() == idx) {
						break;
					}
				}
				;
			}

			// 원래대로 복귀
			// Collections.reverse(party);
		}

		if (searchType.equals("DSB")) {

			if (leftPowerDealerList.size() > 0) { // 일안하는 친구들 재위치에 배치
				for (CharacterVO cvo : leftPowerDealerList) {
					if (synage.equals(cvo.getType())) {
						synagelist.add(cvo);
					} else if (dealer.equals(cvo.getType())) {
						dealerlist.add(cvo);
					}
				}
			}

			// 시너지 리스트 데미지 기준 재정렬(남은 쩔러가 들어갔을경우 데미지순 정렬이 필요했음)
			synagelist.sort(new Comparator<CharacterVO>() {
				@Override
				public int compare(CharacterVO arg0, CharacterVO arg1) {
					// TODO Auto-generated method stub
					long age0 = arg0.getDamage();
					long age1 = arg1.getDamage();

					if (age0 == age1)
						return 0;
					else if (age0 < age1)
						return 1;
					else
						return -1;
				}
			});

			// 버퍼 쩔러 입력 끝
			for (List<CharacterVO> cvoList : party) {
				for (CharacterVO cvo : synagelist) {
					if ( // 쩔러, 버퍼랑 이름이 다르고 쩔딜러랑 직업이 다를떄
					!cvo.getUserId().equals(cvoList.get(0).getUserId())
							&& !cvo.getUserId().equals(cvoList.get(1).getUserId())
							&& !cvo.getJob().equals(cvoList.get(1).getJob())) {
						cvoList.add(cvo);
						synagelist.remove(cvo);
						break;
					}
				}
			}

		}
		
		// 결과 로그 처리
		log.info("[SearchServiceImpl] 파티 작성 완료");
		return party;
	}

	// 예상 파티 데미지 계산
	@Override
	public HashMap<String, Object> calculrateParty(List<List<CharacterVO>> partList) {
		HashMap<String, Object> calculrateParty = new HashMap<String, Object>();
		ArrayList partyDamageList = new ArrayList<>();
		int idx = 1;
		for (List<CharacterVO> cvoList : partList) {
			long partyDamage = 0;
			try {
				log.info("[SearchServiceImpl]" + idx + "번째 파티  멤 버 : " + cvoList.get(0).getUserId() + "-"
						+ cvoList.get(0).getJob() + ", " + cvoList.get(1).getUserId() + "-" + cvoList.get(1).getJob()
						+ ", " + cvoList.get(2).getUserId() + "-" + cvoList.get(2).getJob() + ", 예상 파티 딜 "
						+ (cvoList.get(0).getBuff() * (cvoList.get(1).getDamage() * 1.34
								+ cvoList.get(2).getDamage() * (synage.equals(cvoList.get(1).getType()) ? 1.34 : 1))));
				partyDamage = (long) (cvoList.get(0).getBuff() * (cvoList.get(1).getDamage() * 1.34
						+ cvoList.get(2).getDamage() * (synage.equals(cvoList.get(1).getType()) ? 1.34 : 1)));
			} catch (IndexOutOfBoundsException e) {
				log.info("[SearchServiceImpl]" + idx + "번째 파티  멤 버 : " + cvoList.get(0).getUserId() + "-"
						+ cvoList.get(0).getJob() + ", " + cvoList.get(1).getUserId() + "-" + cvoList.get(1).getJob()
						+ ", 예상 파티 딜 " + (cvoList.get(0).getBuff() * (cvoList.get(1).getDamage())));
				partyDamage = (long) (cvoList.get(0).getBuff() * (cvoList.get(1).getDamage()));
				log.info("시너지가 빠져있는 파티 입니다");
			} catch (Exception e) {
				log.info("" + e);
			}
			idx++;
			partyDamageList.add(partyDamage);
		}

		calculrateParty.put("partList", partList);
		calculrateParty.put("partDamageList", partyDamageList);
		return calculrateParty;
	}

}
