package com.dnd.project.common.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dnd.project.common.user.vo.CmUserVo;


@Repository
public interface CmUserRepository extends CrudRepository<CmUserVo, Object> {
	
	
	
	
	
}
