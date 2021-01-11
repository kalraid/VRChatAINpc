package com.dnd.project.gallery.board.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dnd.project.common.baseUtill.CommonPageVo;
import com.dnd.project.gallery.board.service.BoardService;
import com.dnd.project.gallery.board.vo.CmBoardVo;

import io.swagger.annotations.Api;

@RestController("/api/v1/bd/")
@CrossOrigin
@Api( tags = {"게시판 API"}, description = "게시판 API")
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@PostMapping(value = "/board/list", consumes = "application/json")
	public HttpEntity<Page<CmBoardVo>> list(@RequestBody CmBoardVo vo, @RequestAttribute CommonPageVo pageVo) {
		Page<CmBoardVo> pages = boardService.listBoard(vo, pageVo.init());
		
		HttpHeaders header = new HttpHeaders();
		HttpEntity<Page<CmBoardVo>> HttpEntity = new HttpEntity<Page<CmBoardVo>>(pages, header);
		return HttpEntity;
	}
	
	@GetMapping("/board/{id}")
	public HttpEntity<CmBoardVo> get(@PathVariable("id") long boardId) {
		CmBoardVo vo = CmBoardVo.builder().boardKey(boardId).build();
		vo = boardService.readBoard(vo); 
		
		HttpHeaders header = new HttpHeaders();
		HttpEntity<CmBoardVo> HttpEntity = new HttpEntity<CmBoardVo>(vo, header);
		return HttpEntity;
	}
	
	@PutMapping("/board")
	public HttpEntity<CmBoardVo> insert(CmBoardVo vo) {
		vo = boardService.writeBoard(vo);
		
		HttpHeaders header = new HttpHeaders();
		HttpEntity<CmBoardVo> HttpEntity = new HttpEntity<CmBoardVo>(vo, header);
		return HttpEntity;
	}
	
	@PostMapping("/board")
	public HttpEntity<CmBoardVo> update(CmBoardVo vo) {
		vo = boardService.modifyBoard(vo);
		
		HttpHeaders header = new HttpHeaders();
		HttpEntity<CmBoardVo> HttpEntity = new HttpEntity<CmBoardVo>(vo, header);
		return HttpEntity;
	}
	
	@DeleteMapping("/board")
	public HttpEntity<CmBoardVo> delete(CmBoardVo vo) {
		boardService.deleteBoard(vo);
		
		HttpHeaders header = new HttpHeaders();
		HttpEntity<CmBoardVo> HttpEntity = new HttpEntity<CmBoardVo>(null, header);
		return HttpEntity;
	}
	
	

}