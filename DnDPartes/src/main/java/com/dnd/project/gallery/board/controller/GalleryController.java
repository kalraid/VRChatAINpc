package com.dnd.project.gallery.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
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
import com.dnd.project.gallery.board.service.GalleryService;
import com.dnd.project.gallery.board.vo.CmGalleryVo;

import io.swagger.annotations.Api;

@RestController("/api/v1/ga/")
@CrossOrigin
@Api( tags = {"갤러리(게시판 상위) API"}, description = "갤러리 API")
public class GalleryController {

	@Autowired
	GalleryService galleryService;
	
	@PostMapping(value ="/gallery/list", consumes = "application/json")
	public HttpEntity<Page<CmGalleryVo>> list(@RequestBody CmGalleryVo vo, @RequestAttribute CommonPageVo pageVo) {
		Page<CmGalleryVo> pages = galleryService.listGallery(vo, pageVo.init());
		
		HttpHeaders header = new HttpHeaders();
		HttpEntity<Page<CmGalleryVo>> HttpEntity = new HttpEntity<Page<CmGalleryVo>>(pages, header);
		return HttpEntity;
	}
	
	@GetMapping("/gallery/{id}")
	public HttpEntity<CmGalleryVo> get(@PathVariable("id") String galleryId) {
		CmGalleryVo vo = galleryService.readGallery(CmGalleryVo.builder().galleryKey(Long.parseLong(galleryId)).build());
		
		HttpHeaders header = new HttpHeaders();
		HttpEntity<CmGalleryVo> HttpEntity = new HttpEntity<CmGalleryVo>(vo, header);
		return HttpEntity;
	}
	
	@PutMapping("/gallery")
	public HttpEntity<CmGalleryVo> insert(CmGalleryVo vo) {
		vo = galleryService.writeGallery(vo);
		
		HttpHeaders header = new HttpHeaders();
		HttpEntity<CmGalleryVo> HttpEntity = new HttpEntity<CmGalleryVo>(vo, header);
		return HttpEntity;
	}
	
	@PostMapping("/gallery")
	public HttpEntity<CmGalleryVo> update(CmGalleryVo vo) {
		vo = galleryService.modifyGallery(vo);
		
		HttpHeaders header = new HttpHeaders();
		HttpEntity<CmGalleryVo> HttpEntity = new HttpEntity<CmGalleryVo>(vo, header);
		return HttpEntity;
	}
	
	@DeleteMapping("/gallery")
	public HttpEntity<CmGalleryVo> delete(CmGalleryVo vo) {
		galleryService.deleteGallery(vo);
		
		HttpHeaders header = new HttpHeaders();
		HttpEntity<CmGalleryVo> HttpEntity = new HttpEntity<CmGalleryVo>(null, header);
		return HttpEntity;
	}
	
	

}