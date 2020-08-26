package com.dnd.party.dndOffApi.controller;

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

import com.dnd.party.dndOffApi.service.DnDOffCrawler;

@RestController
@RequestMapping("/api/dndoff")
@CrossOrigin
public class DnDOffController {

	@Autowired
	public DnDOffCrawler dnDOffCrawler;

	
		
	@GetMapping("/characterInfo")
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
}
