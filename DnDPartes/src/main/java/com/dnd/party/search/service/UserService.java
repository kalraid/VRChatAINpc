package com.dnd.party.search.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dnd.party.search.vo.UserVO;

@Service
public interface UserService {

	public List<UserVO> selectUsers(UserVO param);
	

}
