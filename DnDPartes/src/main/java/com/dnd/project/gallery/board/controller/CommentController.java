package com.dnd.project.gallery.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dnd.project.common.baseUtill.CommPageService;
import com.dnd.project.gallery.board.service.CommentService;
import com.dnd.project.gallery.board.vo.CmBoardVo;
import com.dnd.project.gallery.board.vo.CmCommentVo;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin
@Api( tags = {"코멘트 API"}, description = "코멘트 API")
public class CommentController {

	@Autowired
	CommentService commentService;
	
	@Autowired
	CommPageService commPageService;
	
	@PostMapping("/api/v1/comment/list")
	public HttpEntity<Page<CmCommentVo>> list(@RequestBody CmCommentVo vo) {
		Page<CmCommentVo> pages = commentService.listComment(vo, commPageService.paramsToPageable(vo.getPageVo()));
		
		HttpHeaders header = new HttpHeaders();
		HttpEntity<Page<CmCommentVo>> HttpEntity = new HttpEntity<Page<CmCommentVo>>(pages, header);
		return HttpEntity;
	}
	
	@PutMapping("/api/v1/comment")
	public HttpEntity<CmCommentVo> insert(@RequestBody CmCommentVo vo) {
		vo = commentService.writeComment(vo);
		
		HttpHeaders header = new HttpHeaders();
		HttpEntity<CmCommentVo> HttpEntity = new HttpEntity<CmCommentVo>(vo, header);
		return HttpEntity;
	}
	
	@PostMapping("/api/v1/comment")
	public HttpEntity<CmCommentVo> update(@RequestBody CmCommentVo vo) {
		vo = commentService.modifyComment(vo);
		
		HttpHeaders header = new HttpHeaders();
		HttpEntity<CmCommentVo> HttpEntity = new HttpEntity<CmCommentVo>(vo, header);
		return HttpEntity;
	}
	
	@DeleteMapping("/api/v1/comment")
	public HttpEntity<CmCommentVo> delete(@RequestBody CmCommentVo vo) {
		commentService.deleteComment(vo);
		
		HttpHeaders header = new HttpHeaders();
		HttpEntity<CmCommentVo> HttpEntity = new HttpEntity<CmCommentVo>(null, header);
		return HttpEntity;
	}
	
	

}