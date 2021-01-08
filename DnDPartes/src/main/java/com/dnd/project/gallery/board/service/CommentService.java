package com.dnd.project.gallery.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dnd.project.gallery.board.repository.CmCommentRepositoryImpl;
import com.dnd.project.gallery.board.vo.CmBoardVo;
import com.dnd.project.gallery.board.vo.CmCommentVo;

@Service
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
