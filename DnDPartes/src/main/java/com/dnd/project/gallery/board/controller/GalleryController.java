package com.dnd.project.gallery.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnd.project.gallery.board.service.GalleryService;
import com.dnd.project.gallery.board.vo.CmGalleryVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@Api( tags = {"갤러리(게시판 상위) API"}, description = "갤러리 API")
public class GalleryController {

	@Autowired
	GalleryService galleryService;
	
	@ApiOperation("갤러리 목록 조회")
	@PostMapping(value ="/api/v1/gallery/list")
	public HttpEntity<Page<CmGalleryVo>> list(CmGalleryVo vo, Pageable page) {
		Page<CmGalleryVo> pages = galleryService.listGallery(vo, page);
		
		HttpHeaders header = new HttpHeaders();
		HttpEntity<Page<CmGalleryVo>> HttpEntity = new HttpEntity<Page<CmGalleryVo>>(pages, header);
		return HttpEntity;
	}
	
	@GetMapping("/api/v1/gallery/{id}")
	public HttpEntity<CmGalleryVo> get(@PathVariable("id") String galleryId) {
		CmGalleryVo vo = galleryService.readGallery(CmGalleryVo.builder().galleryKey(Long.parseLong(galleryId)).build());
		
		HttpHeaders header = new HttpHeaders();
		HttpEntity<CmGalleryVo> HttpEntity = new HttpEntity<CmGalleryVo>(vo, header);
		return HttpEntity;
	}
	
	@PutMapping("/api/v1/gallery")
	public HttpEntity<CmGalleryVo> insert(CmGalleryVo vo) {
		vo = galleryService.writeGallery(vo);
		
		HttpHeaders header = new HttpHeaders();
		HttpEntity<CmGalleryVo> HttpEntity = new HttpEntity<CmGalleryVo>(vo, header);
		return HttpEntity;
	}
	
	@PostMapping("/api/v1/gallery")
	public HttpEntity<CmGalleryVo> update(CmGalleryVo vo) {
		vo = galleryService.modifyGallery(vo);
		
		HttpHeaders header = new HttpHeaders();
		HttpEntity<CmGalleryVo> HttpEntity = new HttpEntity<CmGalleryVo>(vo, header);
		return HttpEntity;
	}
	
	@DeleteMapping("/api/v1/gallery")
	public HttpEntity<CmGalleryVo> delete(CmGalleryVo vo) {
		galleryService.deleteGallery(vo);
		
		HttpHeaders header = new HttpHeaders();
		HttpEntity<CmGalleryVo> HttpEntity = new HttpEntity<CmGalleryVo>(null, header);
		return HttpEntity;
	}
	
	

}