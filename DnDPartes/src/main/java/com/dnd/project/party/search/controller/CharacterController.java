package com.dnd.project.party.search.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnd.project.party.search.service.CharacterService;
import com.dnd.project.party.search.vo.CharacterVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/character")
@CrossOrigin
public class CharacterController {

	
	@Autowired
	public CharacterService characterService;

	
	@GetMapping("/list")
	public HttpEntity<List<CharacterVO>> SearchSync() {
		List<List<CharacterVO>> partList = null;
		List<CharacterVO> clist = characterService.selectCharacters(new CharacterVO());
		HttpEntity<List<CharacterVO>> result = new HttpEntity<List<CharacterVO>>(clist);
		
		return result;
	}
	
	
	@PostMapping("/change/raidType")
	public HttpEntity<List<CharacterVO>> changeRaidType(@RequestBody CharacterVO cvo) {
		
		int result = characterService.setRaidType(cvo);
		
		ResponseEntity response = new ResponseEntity<>(result==1?HttpStatus.OK:HttpStatus.BAD_REQUEST);
		return response;
	}	
	
	@PostMapping("/change/otherType")
	public HttpEntity<List<CharacterVO>> changeOtherType(@RequestBody CharacterVO cvo) {
		
		int result = characterService.setOtherType(cvo);
		
		ResponseEntity response = new ResponseEntity<>(result==1?HttpStatus.OK:HttpStatus.BAD_REQUEST);
		return response;
	}	
}
