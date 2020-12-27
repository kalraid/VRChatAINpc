package com.dnd.project.party.search.service;

import java.util.List;

import com.dnd.project.party.search.vo.CharacterVO;

public interface CharacterService {

	public List<CharacterVO> selectCharacters(CharacterVO param);
	
	public int setRaidType(CharacterVO param);
	
	public int setOtherType(CharacterVO param);
	
	
}
