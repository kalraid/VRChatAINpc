package com.dnd.project.common.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.dnd.project.common.board.repository.CmCommentRepositoryImpl;
import com.dnd.project.common.board.vo.CmBoardVo;
import com.dnd.project.common.board.vo.CmCommentVo;

public class CommentService {
	@Autowired
	CmCommentRepositoryImpl cmCommentRepositoryImpl;
	
	public Page<CmCommentVo> listComment(CmBoardVo vo, Pageable pageable) {
		CmCommentVo cvo = CmCommentVo.builder().cmBoardVo(vo).build();
		return cmCommentRepositoryImpl.selectComments(cvo, pageable);
	}
	
	public CmCommentVo writeComment(CmCommentVo vo) {
		return cmCommentRepositoryImpl.insertComment(vo);
		
	}
	
	public CmCommentVo modifyComment(CmCommentVo vo) {
		return cmCommentRepositoryImpl.updateComment(vo);
		
	}
	
	public void deleteComment(CmCommentVo vo) {
		cmCommentRepositoryImpl.deleteComment(vo);
		
	}
}
