package com.dnd.project.party.search.service;

import java.util.HashMap;
import java.util.List;

import com.dnd.project.party.search.vo.CharacterVO;

public interface SearchService {

	public List<List<CharacterVO>> selectParty(HashMap<String, Object> users);

	public HashMap<String, Object> calculrateParty(List<List<CharacterVO>> partList);

}
