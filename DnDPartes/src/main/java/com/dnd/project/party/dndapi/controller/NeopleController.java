package com.dnd.project.party.dndapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnd.project.party.dndapi.api.NeopleRest;

@RestController
@RequestMapping("/api/v1/neople/")
@CrossOrigin
public class NeopleController {

	@Autowired
	public NeopleRest neopleRest;
	
	@GetMapping("/serverInfo")
	public HttpEntity<?> getServerInfo() {
		return neopleRest.getServerInfo();
	}
	
	@GetMapping("/jobInfo")
	public HttpEntity<?> getJobInfo() {
		return neopleRest.getJobInfo();
	}

}