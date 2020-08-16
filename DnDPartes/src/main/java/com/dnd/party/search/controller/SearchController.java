package com.dnd.party.search.controller;

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

import com.dnd.party.search.service.SearchService;
import com.dnd.party.search.service.UserService;
import com.dnd.party.search.vo.CharacterVO;

@RestController
@RequestMapping("/search")
@CrossOrigin
public class SearchController {

	@Autowired
	private UserService userService;

	@Autowired
	private SearchService searchService;

	@PostMapping("/start")
	public HttpEntity<List<List<CharacterVO>>> SearchStart(@RequestBody HashMap<String, Object> param) {
		List<List<CharacterVO>> partList = searchService.selectParty(param);

		HttpEntity<List<List<CharacterVO>>> result = new HttpEntity<List<List<CharacterVO>>>(partList);
	
		return result;
	}
	
	@GetMapping("/sync")
	public HttpEntity<List<List<CharacterVO>>> SearchSync() {
		List<List<CharacterVO>> partList = null;
		
		HttpEntity<List<List<CharacterVO>>> result = new HttpEntity<List<List<CharacterVO>>>(partList);
		
		return result;
	}

}