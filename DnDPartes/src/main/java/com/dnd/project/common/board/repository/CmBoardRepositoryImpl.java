package com.dnd.project.common.board.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.dnd.project.common.baseUtill.CommonSpecification;
import com.dnd.project.common.board.vo.CmBoardVo;

import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
public class CmBoardRepositoryImpl{
	@Autowired
	CmBoardRepository cmBoardRepository;
	
	@Autowired
	CommonSpecification commonSpecification;
	
	public CmBoardVo selectBoard(CmBoardVo cmBoardVo) {
		return cmBoardRepository.getOne(cmBoardVo.getBoardKey());
	}
	
	public Page<CmBoardVo> selectBoards(CmBoardVo cmBoardVo, Pageable pageable) {
		return cmBoardRepository.findAll((Specification<CmBoardVo>) CommonSpecification.searchWith(cmBoardVo), pageable);
	}
	
	public CmBoardVo insertBoard(CmBoardVo cmBoardVo) {
		return cmBoardRepository.save(cmBoardVo);
	}
	
	public List<CmBoardVo> insertBoards(List<CmBoardVo> entities) {
		return cmBoardRepository.saveAll(entities);
	}
	
	public CmBoardVo updateBoard(CmBoardVo cmBoardVo) {
		if(cmBoardRepository.findById(cmBoardVo.getBoardKey()).isPresent()) {
			log.info("update");
			return cmBoardRepository.save(cmBoardVo);
		}else {
			log.info("inesrt");
			return cmBoardRepository.save(cmBoardVo);
		}
		
	}
	
	public List<CmBoardVo> updateBoards(List<CmBoardVo> entities) {
		
		return cmBoardRepository.saveAll(entities);
	}
	
	public void deleteBoard(CmBoardVo cmBoardVo) {
		
		cmBoardRepository.delete(cmBoardVo);
	}
	
	public void deleteBoards(List<CmBoardVo> entities) {
		
		cmBoardRepository.deleteAll(entities);
	}
	
	
	
	
}
