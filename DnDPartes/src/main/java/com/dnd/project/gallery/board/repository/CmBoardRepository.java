package com.dnd.project.gallery.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.dnd.project.gallery.board.vo.CmBoardVo;;


@Repository
public interface CmBoardRepository extends JpaRepository<CmBoardVo, Long>, JpaSpecificationExecutor<CmBoardVo> {
	
	
	
	
	
}
