package com.dnd.project.party.search.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dnd.project.party.search.vo.UserVO;

@Mapper
public interface UserDAO {


	public List<UserVO> selectUsers(UserVO param);
}
