package com.dnd.project.gallery.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.dnd.project.gallery.user.vo.CmUserVo;

@Repository
public interface CmUserRepository extends JpaRepository<CmUserVo, Long>, JpaSpecificationExecutor<CmUserVo> {
	
	
}
