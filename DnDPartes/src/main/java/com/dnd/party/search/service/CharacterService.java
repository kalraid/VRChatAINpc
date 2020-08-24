package com.dnd.party.search.service;

import java.util.List;

import com.dnd.party.search.vo.CharacterVO;

public interface CharacterService {

	public List<CharacterVO> selectCharacters(CharacterVO param);
	
	public int setRaidType(CharacterVO param);
	
	public int setOtherType(CharacterVO param);
}
