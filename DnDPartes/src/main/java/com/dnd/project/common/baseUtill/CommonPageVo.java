package com.dnd.project.common.baseUtill;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CommonPageVo {

	private int page;
	
	private int size;
	
	private Direction direction = Direction.DESC;
	
	private String order;
	
	public Pageable init() {
		return PageRequest.of(this.page, this.size, this.direction, this.order);
		
	}
	
}
