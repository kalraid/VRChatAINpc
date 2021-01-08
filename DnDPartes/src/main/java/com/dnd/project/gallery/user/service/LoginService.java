package com.dnd.project.gallery.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnd.project.common.token.JwtAuthenticationToken;
import com.dnd.project.common.token.JwtAuthenticationTokenProvider;
import com.dnd.project.gallery.user.repository.CmUserRepositoryImpl;
import com.dnd.project.gallery.user.vo.CmUserVo;

@Service
public class LoginService {
	
	@Autowired
	CmUserRepositoryImpl cmUserRepositoryImpl;
	
	@Autowired
	JwtAuthenticationTokenProvider jwtAuthenticationTokenProvider;
	
	
	public CmUserVo login(CmUserVo vo) {
		
		CmUserVo cmUserVo = cmUserRepositoryImpl.selectUser(vo);
		JwtAuthenticationToken token = jwtAuthenticationTokenProvider.issue(cmUserVo.getUserKey());
		cmUserVo.setToken(token.getToken());
		return cmUserVo;
	}
	public CmUserVo logout(CmUserVo vo) {
		return null;
	}
	public CmUserVo sign(CmUserVo vo) {
		CmUserVo cmUserVo = cmUserRepositoryImpl.insertUser(vo);
		return cmUserVo;
	}
	
}
