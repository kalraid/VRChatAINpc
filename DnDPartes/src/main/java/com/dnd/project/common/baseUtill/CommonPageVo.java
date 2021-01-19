package com.dnd.project.common.baseUtill;

import java.util.ArrayList;

import javax.persistence.Transient;

import org.springframework.data.domain.Sort.Direction;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CommonPageVo {

	@Transient
	public int page = 0;

	@Transient
	public int size = 10;
	
	@Transient
	public String orderColumns = "";
	
	@Transient
	public String order = "ASC";

	@JsonIgnore
	public Direction getOrder() {
		if(this.order.toUpperCase().equals("ASC")) {
			return Direction.ASC;
		}else {
			return Direction.DESC;
		}
	}
	
	@JsonIgnore
	public Boolean isOrderBy() {
		if(StringUtils.isEmpty(orderColumns)) {
			return false;
		}else {
			return true;
		}
	}
	
}
