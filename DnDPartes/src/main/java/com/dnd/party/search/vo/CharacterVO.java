package com.dnd.party.search.vo;

import java.util.Date;

import lombok.Data;

@Data
public class CharacterVO {

	private String id;
	private String apiId;
	private String name;
	private long damage;
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
	private String sirocoRemainCount;
	private String bannerRemainCount;
	private Date sirocoDate;
	private Date bannerDate;
	private Date oculusDate;
	private Date devildomDate;
	private Date findDate;
	private Date freyIsisDate;
	private int powerLevel;
	private int partyIdx;

	private String serverId;
	private long damageSiroco;
	private long damageSendbag;
	private double buffAria;
	
	private int raidParticipateType;
	private int otherParticipateType;
	
	private Boolean partcipate = false;
	
	
}
