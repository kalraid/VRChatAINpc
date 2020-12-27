package com.dnd.project.common.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnd.project.common.user.repository.CmUserRepositoryImpl;

@Service
public class LoginService {
	
	@Autowired
	CmUserRepositoryImpl cmUserRepositoryImpl;
	
	
	public String login() {
		cmUserRepositoryImpl.selectUser();
		return "";
	}
	public String logout() {
		
		return "";
	}
	public String sign() {
		
		return "";
	}
	
}
