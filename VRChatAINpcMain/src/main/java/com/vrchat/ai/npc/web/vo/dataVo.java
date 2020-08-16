package com.vrchat.ai.npc.web.vo;

import java.util.UUID;

import lombok.Data;

@Data
public class dataVo {
	private String id = UUID.randomUUID().toString();
	private String name;
	private String password;
}
