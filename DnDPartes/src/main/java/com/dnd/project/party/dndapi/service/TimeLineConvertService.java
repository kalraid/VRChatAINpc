package com.dnd.project.party.dndapi.service;

import org.springframework.http.ResponseEntity;

import com.dnd.project.party.dndapi.vo.dndResponse;

public interface TimeLineConvertService {

	public String updateTimeLineToCharacter(ResponseEntity<? extends dndResponse> entity, String characterId);
	
}
