package com.dnd.project.gallery.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dnd.project.gallery.board.service.CommentService;
import com.dnd.project.gallery.board.vo.CmBoardVo;
import com.dnd.project.gallery.board.vo.CmCommentVo;

@RestController("/api/v1/cm/")
@CrossOrigin
public class CommentController {

	@Autowired
	CommentService commentService;
	
	@GetMapping("/comment/list")
	public HttpEntity<Page<CmCommentVo>> list(@RequestBody CmBoardVo vo, Pageable pageable) {
		Page<CmCommentVo> pages = commentService.listComment(vo, pageable);
		
		HttpHeaders header = new HttpHeaders();
		HttpEntity<Page<CmCommentVo>> HttpEntity = new HttpEntity<Page<CmCommentVo>>(pages, header);
		return HttpEntity;
	}
	
	@PutMapping("/comment")
	public HttpEntity<CmCommentVo> insert(CmCommentVo vo) {
		vo = commentService.writeComment(vo);
		
		HttpHeaders header = new HttpHeaders();
		HttpEntity<CmCommentVo> HttpEntity = new HttpEntity<CmCommentVo>(vo, header);
		return HttpEntity;
	}
	
	@PostMapping("/comment")
	public HttpEntity<CmCommentVo> update(CmCommentVo vo) {
		vo = commentService.modifyComment(vo);
		
		HttpHeaders header = new HttpHeaders();
		HttpEntity<CmCommentVo> HttpEntity = new HttpEntity<CmCommentVo>(vo, header);
		return HttpEntity;
	}
	
	@DeleteMapping("/comment")
	public HttpEntity<CmCommentVo> delete(CmCommentVo vo) {
		commentService.deleteComment(vo);
		
		HttpHeaders header = new HttpHeaders();
		HttpEntity<CmCommentVo> HttpEntity = new HttpEntity<CmCommentVo>(null, header);
		return HttpEntity;
	}
	
	

}