package com.dnd.project.common.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dnd.project.common.board.repository.CmGalleryRepositoryImpl;
import com.dnd.project.common.board.vo.CmGalleryVo;

@Service
public class GalleryService {
	@Autowired
	CmGalleryRepositoryImpl cmGalleryRepositoryImpl;
	
	public Page<CmGalleryVo> listGallery(CmGalleryVo vo, Pageable pageable) {
		return cmGalleryRepositoryImpl.selectGallerys(vo, pageable);
	}
	public CmGalleryVo readGallery(CmGalleryVo vo) {
		return cmGalleryRepositoryImpl.selectGallery(vo);
	}
	
	public CmGalleryVo writeGallery(CmGalleryVo vo) {
		return cmGalleryRepositoryImpl.insertGallery(vo);
		
	}
	
	public CmGalleryVo modifyGallery(CmGalleryVo vo) {
		return cmGalleryRepositoryImpl.updateGallery(vo);
		
	}
	
	public void deleteGallery(CmGalleryVo vo) {
		cmGalleryRepositoryImpl.deleteGallery(vo);
		
	}
}
