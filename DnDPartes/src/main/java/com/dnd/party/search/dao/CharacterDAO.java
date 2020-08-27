package com.dnd.party.search.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dnd.party.search.vo.CharacterVO;
import com.dnd.party.search.vo.SearchCheckVO;

@Mapper
public interface CharacterDAO {
	
	public List<CharacterVO> selectCharacters(CharacterVO param);
	
	public List<CharacterVO> getBuffList(SearchCheckVO scvo);
	public List<CharacterVO> getSynageList(SearchCheckVO scvo);
	public List<CharacterVO> getDealarList(SearchCheckVO scvo);
	public List<CharacterVO> getPowerDealerList(SearchCheckVO scvo);
	public int saveCharacterApiId(CharacterVO param);
	public int insertCharacterDetailHist(CharacterVO param);
	public int saveCharacterDetail(CharacterVO param);

	public int setRaidType(CharacterVO param);
	public int setOtherType(CharacterVO param);
	
}