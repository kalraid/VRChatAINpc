package com.dnd.project.party.search.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dnd.project.party.search.vo.PartyVO;

@Mapper
public interface PartyDAO {

	List<PartyVO> selectParty(PartyVO param);
}
