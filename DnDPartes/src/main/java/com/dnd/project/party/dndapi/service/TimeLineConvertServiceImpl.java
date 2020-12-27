package com.dnd.project.party.dndapi.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.dnd.project.party.dndapi.vo.dndResponse;
import com.dnd.project.party.dndapi.vo.dndTimeline.timeLine;
import com.dnd.project.party.search.dao.CharacterDAO;
import com.dnd.project.party.search.service.CharacterService;
import com.dnd.project.party.search.vo.CharacterVO;
import com.dnd.project.party.utils.NeopleCode;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TimeLineConvertServiceImpl implements TimeLineConvertService {

	@Autowired
	CharacterService characterService;
	
	@Autowired
	CharacterDAO characterDAO;
	
	@Override
	public String updateTimeLineToCharacter(ResponseEntity<? extends dndResponse> entity, String characterId) {
		CharacterVO param = new CharacterVO();
		param.setApiId(characterId);
		// characterService.selectCharacters(param);
		if(!ObjectUtils.isEmpty(entity.getBody().getTimeline()) && !ObjectUtils.isEmpty(entity.getBody().getTimeline().getRows())) {
			try {
				param = dndTimeLineTo(entity.getBody().getTimeline().getRows(), characterId);
				characterDAO.updateCharacterHist(param);
				log.info("[TimeLineConvertServiceImpl] 업데이트 성공 - 케릭터 ApiId : "+characterId);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	private CharacterVO dndTimeLineTo(ArrayList<timeLine> rows,String characterId) throws ParseException {
		int oculusRemainCount = 3;
		int devildomRemainCount = 2;
		int findRemainCount = 2;
		int freyIsisRemainCount = 2;
		int sirocoRemainCount = 2;
		int bannerRemainCount = 3;
		Date sirocoDate = null;
		Date bannerDate = null;
		Date oculusDate = null;
		Date devildomDate = null;
		Date findDate = null;
		Date freyIsisDate = null;
		CharacterVO cvo = new CharacterVO();
		SimpleDateFormat sdf = new SimpleDateFormat();
		for (timeLine row : rows) {
			if(NeopleCode.FIND_WAR.equals(row.getCode())) {
				findRemainCount--;
				findDate = sdf.parse(row.getDate());
			}else if(NeopleCode.RAID.equals(row.getCode())) {
				if(row.getName().equals(NeopleCode.RAID_NAME_FREY)) {
					freyIsisRemainCount--;
					freyIsisDate = sdf.parse(row.getDate());
				}else if(row.getName().equals(NeopleCode.RAID_NAME_SIROCO)) {
					
					if("토벌".equals(row.getData().getPhaseName())) {
						freyIsisRemainCount--;
						sirocoDate = sdf.parse(row.getDate());
					}
				}
			}
			
		}
		
		cvo.setApiId(characterId);
		cvo.setOculusRemainCount(oculusRemainCount+"");
		cvo.setDevildomRemainCount(devildomRemainCount+"");
		cvo.setFindRemainCount(findRemainCount+"");
		cvo.setFreyIsisRemainCount(freyIsisRemainCount+"");
		cvo.setSirocoRemainCount(sirocoRemainCount+"");
		cvo.setBannerRemainCount(bannerRemainCount+"");
		cvo.setSirocoDate(sirocoDate);
		cvo.setBannerDate(bannerDate);
		cvo.setOculusDate(oculusDate);
		cvo.setDevildomDate(devildomDate);
		cvo.setFindDate(findDate);
		cvo.setFreyIsisDate(freyIsisDate);
		
		return cvo;
	}
}
