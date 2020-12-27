package com.dnd.project.party.search.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnd.project.party.search.dao.UserDAO;
import com.dnd.project.party.search.vo.UserVO;

@Service
public class UserServiceimpl implements UserService{

	@Autowired
	private UserDAO userDAO;
	
	public List<UserVO> selectUsers(UserVO param) {
		return userDAO.selectUsers(param);
	}
}
