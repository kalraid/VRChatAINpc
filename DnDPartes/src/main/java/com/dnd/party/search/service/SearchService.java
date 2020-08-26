package com.dnd.party.search.service;

import java.util.HashMap;
import java.util.List;

import com.dnd.party.search.vo.CharacterVO;

public interface SearchService {

	public List<List<CharacterVO>> selectParty(HashMap<String, Object> users);

	public HashMap<String, Object> calculrateParty(List<List<CharacterVO>> partList);

}
