package com.dnd.project.party.utils;

public enum NeopleCode {

		WEEK("week"),
		EPIC("epic"),
		GET_ITEM_DUNGEN("513"),
		RAID("201"),
		FIND_WAR("207"),
		GET_ITEM_HELL("505"),
		SUBJUGATION("토벌"),
		TRACKING("추적"),
		RAID_NAME_SIROCO("무형의 시로코"),
		RAID_NAME_FREY("프레이-이시스");
	
	
		
		private String type;
		
		NeopleCode(String type){
			this.type = type;
		}

		public String getType() {
			return type;
		}
		
}
