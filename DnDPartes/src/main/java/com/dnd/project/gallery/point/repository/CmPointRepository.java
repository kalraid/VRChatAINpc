package com.dnd.project.gallery.point.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.dnd.project.gallery.point.vo.CmPointVo;

@Repository
public interface CmPointRepository extends JpaRepository<CmPointVo, Long>, JpaSpecificationExecutor<CmPointVo> {
	
	
}
