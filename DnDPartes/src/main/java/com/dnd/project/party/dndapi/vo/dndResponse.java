package com.dnd.project.party.dndapi.vo;

import lombok.Data;

@Data
public class dndResponse<T>{
//	{
//	    "characterId": "e967eee957794439886327170d6af17f",
//	    "characterName": "에반젤앙갚음",
//	    "level": 100,
//	    "jobId": "0c1b401bb09241570d364420b3ba3fd7",
//	    "jobGrowId": "80ec67d0356defa46a989914caca5820",
//	    "jobName": "프리스트(여)",
//	    "jobGrowName": "세라핌",
//	    "adventureName": "앙갚음사적단",
//	    "guildId": "e91ea57c5556b4ca574a9081b56e8ad5",
//	    "guildName": "★호갱님★",
//	}
	
    String characterId;
    String characterName;
    String level;
    String jobId;
    String jobGrowId;
    String jobName;
    String jobGrowName;
    String adventureName;
    String guildId;
    String guildName;
    dndTimeline timeline;
    
 
}
