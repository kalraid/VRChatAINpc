package com.dnd.party.dndapi.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dnd.party.dndapi.vo.dndResponse;

public interface TimeLineConvertService {

	public String updateTimeLineToCharacter(ResponseEntity<? extends dndResponse> entity, String characterId);
	
}
