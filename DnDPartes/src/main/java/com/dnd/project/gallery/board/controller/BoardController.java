package com.dnd.project.gallery.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.dnd.project.common.baseUtill.CommPageService;
import com.dnd.project.gallery.board.service.BoardService;
import com.dnd.project.gallery.board.vo.CmBoardVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@Api(tags = { "게시판 API" }, description = "게시판 API")
public class BoardController {

	@Autowired
	BoardService boardService;

	@Autowired
	CommPageService commPageService; 
	
	@ApiOperation("게시판 목록 조회")
	@PostMapping(value = "/api/v1/board/list")
	public HttpEntity<Page<CmBoardVo>> list(@RequestBody CmBoardVo board) {
		Page<CmBoardVo> pages = boardService.listBoard(board, commPageService.paramsToPageable(board.getPageVo()));
		
        HttpHeaders header = new HttpHeaders();
		HttpEntity<Page<CmBoardVo>> HttpEntity = new HttpEntity<Page<CmBoardVo>>(pages, header);
		return HttpEntity;
	}

	@GetMapping("/api/v1/board/{id}")
	public HttpEntity<CmBoardVo> get(@PathVariable("id") long boardId) {
		CmBoardVo vo = CmBoardVo.builder().boardKey(boardId).build();
		vo = boardService.readBoard(vo);

		HttpHeaders header = new HttpHeaders();
		HttpEntity<CmBoardVo> HttpEntity = new HttpEntity<CmBoardVo>(vo, header);
		return HttpEntity;
	}

	@PutMapping("/api/v1/board")
	public HttpEntity<CmBoardVo> insert(@RequestBody CmBoardVo vo) {
		vo = boardService.writeBoard(vo);

		HttpHeaders header = new HttpHeaders();
		HttpEntity<CmBoardVo> HttpEntity = new HttpEntity<CmBoardVo>(vo, header);
		return HttpEntity;
	}

	@PostMapping("/api/v1/board")
	public HttpEntity<CmBoardVo> update(@RequestBody CmBoardVo vo) {
		vo = boardService.modifyBoard(vo);

		HttpHeaders header = new HttpHeaders();
		HttpEntity<CmBoardVo> HttpEntity = new HttpEntity<CmBoardVo>(vo, header);
		return HttpEntity;
	}

	@DeleteMapping("/api/v1/board")
	public HttpEntity<CmBoardVo> delete(@RequestBody CmBoardVo vo) {
		boardService.deleteBoard(vo);

		HttpHeaders header = new HttpHeaders();
		HttpEntity<CmBoardVo> HttpEntity = new HttpEntity<CmBoardVo>(null, header);
		return HttpEntity;
	}

}