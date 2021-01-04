package com.dnd.project.common.point.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dnd.project.common.board.vo.CmBoardVo;
import com.dnd.project.common.point.vo.CmPointVo;

@Repository
public interface CmPointRepository extends JpaRepository<CmPointVo, Long>, JpaSpecificationExecutor<CmPointVo> {
	
	
}
