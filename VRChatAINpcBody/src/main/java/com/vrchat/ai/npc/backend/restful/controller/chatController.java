package com.vrchat.ai.npc.backend.restful.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
@Slf4j
public class chatController {

	@GetMapping("/getServer")
	public String getServer(String string1) {

		return "{data: chat1}";
	}
	
	@GetMapping("/getId")
	public String getId(String string1) {
		
		return "{data: chat2}";
	}
	
	@GetMapping("/getServerList")
	public String getServerList(String string1) {
		
		return "{data: chat3}";
	}
	
	@GetMapping("/getMemberList")
	public String getMemberList(String string1) {
		
		return "{data: chat4}";
	}
	
	@GetMapping("/getImage")
	public String getImage(String string1) {
		
		return "{data: chat5}";
	}
	
	@GetMapping("/getChatList")
	public String getChatList(String string1) {
		
		return "{data: chat6}";
	}
	
	
}
