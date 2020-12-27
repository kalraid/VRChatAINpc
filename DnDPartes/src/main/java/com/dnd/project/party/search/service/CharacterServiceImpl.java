package com.dnd.project.party.search.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnd.project.party.search.dao.CharacterDAO;
import com.dnd.project.party.search.vo.CharacterVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CharacterServiceImpl implements CharacterService{

	@Autowired
	public CharacterDAO characterDAO; 
	
	public List<CharacterVO> selectCharacters(CharacterVO param){
		return characterDAO.selectCharacters(param);
	}

	@Override
	public int setRaidType(CharacterVO param) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setOtherType(CharacterVO param) {
		// TODO Auto-generated method stub
		return 0;
	};
}
