package com.dnd.project.common.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.dnd.project.common.user.vo.CmUserVo;

@Repository
public interface CmUserRepository extends JpaRepository<CmUserVo, Long>, JpaSpecificationExecutor<CmUserVo> {
	
	
}
