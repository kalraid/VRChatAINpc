package com.dnd.project.common.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnd.project.common.user.service.LoginService;
import com.dnd.project.common.user.vo.CmUserVo;

@RestController
@CrossOrigin
public class loginController {

	@Autowired
	LoginService loginService;
	
	@PostMapping("/login")
	public HttpEntity<CmUserVo> login(CmUserVo vo) {
		vo = loginService.login(vo);
		
		HttpHeaders header = new HttpHeaders();
		header.add("Authrization", vo.getToken());
		HttpEntity<CmUserVo> HttpEntity = new HttpEntity<CmUserVo>(vo, header);
		return HttpEntity;
	}
	
	@PostMapping("/logout")
	public HttpEntity<CmUserVo> logout(CmUserVo vo) {
		vo = loginService.logout(vo); // null return
		
		HttpHeaders header = new HttpHeaders();
		HttpEntity<CmUserVo> HttpEntity = new HttpEntity<CmUserVo>(vo, header);
		return HttpEntity;
	}
	
	@PostMapping("/sign")
	public HttpEntity<CmUserVo> sign(CmUserVo vo) {
		
		vo = loginService.sign(vo);
		
		HttpHeaders header = new HttpHeaders();
		header.add("Authrization", vo.getToken());
		HttpEntity<CmUserVo> HttpEntity = new HttpEntity<CmUserVo>(vo, header);
		return HttpEntity;
	}
	
	

}