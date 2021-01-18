package com.dnd.project.gallery.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dnd.project.gallery.board.service.BoardService;
import com.dnd.project.gallery.board.vo.CmBoardVo;
import com.dnd.project.gallery.board.vo.CmGalleryVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@Api(tags = { "게시판 API" }, description = "게시판 API")
public class BoardController {

	@Autowired
	BoardService boardService;

	@ApiOperation("게시판 목록 조회")
	@PostMapping(value = "/api/v1/board/list")
	public HttpEntity<Page<CmBoardVo>> list(@ModelAttribute(value="vo") CmBoardVo vo,
			@ModelAttribute(value="gallery") CmGalleryVo gallery, @ModelAttribute(value="pageable") Pageable page) {
		Page<CmBoardVo> pages = boardService.listBoard(vo, page);

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
	public HttpEntity<CmBoardVo> insert(@RequestParam CmBoardVo vo) {
		vo = boardService.writeBoard(vo);

		HttpHeaders header = new HttpHeaders();
		HttpEntity<CmBoardVo> HttpEntity = new HttpEntity<CmBoardVo>(vo, header);
		return HttpEntity;
	}

	@PostMapping("/api/v1/board")
	public HttpEntity<CmBoardVo> update(@RequestParam CmBoardVo vo) {
		vo = boardService.modifyBoard(vo);

		HttpHeaders header = new HttpHeaders();
		HttpEntity<CmBoardVo> HttpEntity = new HttpEntity<CmBoardVo>(vo, header);
		return HttpEntity;
	}

	@DeleteMapping("/api/v1/board")
	public HttpEntity<CmBoardVo> delete(@RequestParam CmBoardVo vo) {
		boardService.deleteBoard(vo);

		HttpHeaders header = new HttpHeaders();
		HttpEntity<CmBoardVo> HttpEntity = new HttpEntity<CmBoardVo>(null, header);
		return HttpEntity;
	}

}