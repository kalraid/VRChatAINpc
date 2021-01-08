package com.dnd.project.gallery.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.dnd.project.gallery.board.vo.CmCommentVo;;


@Repository
public interface CmCommentRepository extends JpaRepository<CmCommentVo, Long>, JpaSpecificationExecutor<CmCommentVo> {
	
	
	
	
	
}
