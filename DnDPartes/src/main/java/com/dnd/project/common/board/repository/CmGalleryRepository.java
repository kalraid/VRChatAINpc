package com.dnd.project.common.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.dnd.project.common.board.vo.CmGalleryVo;


@Repository
public interface CmGalleryRepository extends JpaRepository<CmGalleryVo, Long>, JpaSpecificationExecutor<CmGalleryVo> {
	
	
	
	
	
}
