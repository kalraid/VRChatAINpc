package com.dnd.project.party.search.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnd.project.party.search.service.UserService;
import com.dnd.project.party.search.vo.UserVO;

@RestController
@RequestMapping("/api/v1/df/us")
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/users/list")
	public List<UserVO> users() { 
		UserVO param = new UserVO();
		param.setId("1");
		List<UserVO> userList = userService.selectUsers(param);// 22번 째 줄에서 생성한 객체를 파라미터로 전달하여 DB로부터 사용자 목록을 불러온다.
		return userList;
	}
	
}
