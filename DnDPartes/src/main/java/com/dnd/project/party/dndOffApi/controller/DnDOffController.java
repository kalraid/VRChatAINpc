package com.dnd.project.party.dndOffApi.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnd.project.party.dndOffApi.service.DnDOffCrawler;
import com.dnd.project.party.dndOffApi.service.DnDOffSeleniumCrawler;

@RestController
@RequestMapping("/api/v1/dnd")
@CrossOrigin
public class DnDOffController {

	@Autowired
	public DnDOffCrawler dnDOffCrawler;
	
	@Autowired
	public DnDOffSeleniumCrawler DnDOffSeleniumCrawler;
		
	@GetMapping("/dndoff/characterInfo")
	public HttpEntity<?> getData() throws ParseException {
		List<HashMap<String, String>> body;
		try {
			body = dnDOffCrawler.getData();
			ResponseEntity<?> response = new ResponseEntity(body,  HttpStatus.OK);
			
			return response;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/dndoff/characterInfoDetail")
	public HttpEntity<?> getDataDetail() throws ParseException, InterruptedException {
		List<HashMap<String, String>> body;
		body = DnDOffSeleniumCrawler.getData();
		ResponseEntity<?> response = new ResponseEntity(body,  HttpStatus.OK);
		
		return response;
	}
	
}
