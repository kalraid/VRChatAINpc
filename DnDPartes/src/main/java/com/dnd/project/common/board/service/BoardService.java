package com.dnd.project.common.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dnd.project.common.board.repository.CmBoardRepositoryImpl;
import com.dnd.project.common.board.vo.CmBoardVo;

@Service
public class BoardService {
	@Autowired
	CmBoardRepositoryImpl cmBoardRepositoryImpl;
	
	public Page<CmBoardVo> listBoard(CmBoardVo vo, Pageable pageable) {
		return cmBoardRepositoryImpl.selectBoards(vo, pageable);
	}
	public CmBoardVo readBoard(CmBoardVo vo) {
		return cmBoardRepositoryImpl.selectBoard(vo);
	}
	
	public CmBoardVo writeBoard(CmBoardVo vo) {
		return cmBoardRepositoryImpl.insertBoard(vo);
		
	}
	
	public CmBoardVo modifyBoard(CmBoardVo vo) {
		return cmBoardRepositoryImpl.updateBoard(vo);
		
	}
	
	public void deleteBoard(CmBoardVo vo) {
		cmBoardRepositoryImpl.deleteBoard(vo);
		
	}
	
}
