package com.dnd.project.gallery.board.service;

import java.util.List;

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
	
	public Page<CmCommentVo> listComment(CmCommentVo vo, Pageable pageable) {
		return cmCommentRepositoryImpl.selectComments(vo, pageable);
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
