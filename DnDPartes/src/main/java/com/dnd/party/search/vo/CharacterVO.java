package com.dnd.party.search.vo;

import java.util.Date;

import lombok.Data;

@Data
public class CharacterVO {

	private String id;
	private String name;
	private int damage;
	private double buff;
	private String job;
	private String type;
	private String advName;
	private String userId;
	private String userAlias;
	private String oculusRemainCount;
	private String devildomRemainCount;
	private String findRemainCount;
	private String freyIsisRemainCount;
	private Date oculusDate;
	private Date devildomDate;
	private Date findDate;
	private Date freyIsisDate;
	private int powerLevel;
	private int partyIdx;
	
}
