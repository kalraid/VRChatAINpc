package com.dnd.project.common.baseUtill;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CommPageService {

	
	/***
	 * 받은 page 관련 객체를 pageable로 변환하여 반환 
	 * @param CommonPageVo page
	 * @return Pageable
	 */
	public Pageable paramsToPageable(CommonPageVo page) {
		if(page.isOrderBy()) {
			return PageRequest.of(page.getPage(), page.getSize(), Sort.by(page.getOrder(), page.getOrderColumns()));
		}else {
			return PageRequest.of(page.getPage(), page.getSize());
		}
	}
}
