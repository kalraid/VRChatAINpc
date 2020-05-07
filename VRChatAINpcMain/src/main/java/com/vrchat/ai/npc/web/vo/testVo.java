package com.vrchat.ai.npc.web.vo;

import lombok.Data;

@Data
public class testVo {
	private String firstName;
	private String lastName;
	
	public testVo(String string, String string2) {
		this.firstName = string;
		this.lastName = string2;
	}
}
