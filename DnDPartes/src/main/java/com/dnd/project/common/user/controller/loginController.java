package com.dnd.project.common.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnd.project.common.user.service.LoginService;

@RestController
@CrossOrigin
public class loginController {

	@Autowired
	LoginService cmUserService;
	
	@PostMapping("/login")
	public HttpEntity<?> login() {
		return null;
	}
	
	@PostMapping("/logout")
	public HttpEntity<?> logout() {
		return null;
	}
	
	@PostMapping("/sign")
	public HttpEntity<?> sign() {
		return null;
	}
	
	

}