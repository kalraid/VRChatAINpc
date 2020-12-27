package com.dnd.project.common.point.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dnd.project.common.point.vo.CmPointVo;

@Repository
public interface CmPointRepository extends CrudRepository<CmPointVo, Object> {
	
	
	
}
