package com.dnd.project.party.search.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnd.project.party.search.service.SearchService;
import com.dnd.project.party.search.service.UserService;
import com.dnd.project.party.search.vo.CharacterVO;

@RestController
@RequestMapping("/api/v1/df/se")
@CrossOrigin
public class SearchController {

	@Autowired
	private UserService userService;

	@Autowired
	private SearchService searchService;

	@PostMapping("/search/start")
	public HttpEntity<HashMap<String, Object>> SearchStart(@RequestBody HashMap<String, Object> param) {
		List<List<CharacterVO>> partList = searchService.selectParty(param);
		HashMap<String, Object> body = searchService.calculrateParty(partList);
		HttpEntity<HashMap<String, Object>> result = new HttpEntity<HashMap<String, Object>>(body);
	
		return result;
	}
	
	@GetMapping("/search/sync")
	public HttpEntity<List<List<CharacterVO>>> SearchSync() {
		List<List<CharacterVO>> partList = null;
		
		HttpEntity<List<List<CharacterVO>>> result = new HttpEntity<List<List<CharacterVO>>>(partList);
		
		return result;
	}

}