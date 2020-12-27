package com.dnd.project.party.search.vo;

import java.util.List;

import lombok.Data;

@Data
public class SearchCheckVO {

	List<UserVO> users;
	String selected;
}
