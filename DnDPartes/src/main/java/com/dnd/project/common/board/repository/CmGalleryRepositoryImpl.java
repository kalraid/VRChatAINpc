package com.dnd.project.common.board.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.dnd.project.common.baseUtill.CommonSpecification;
import com.dnd.project.common.board.vo.CmGalleryVo;

import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
public class CmGalleryRepositoryImpl{
	
		@Autowired
		CmGalleryRepository cmGalleryRepository;
		
		@Autowired
		CommonSpecification commonSpecification;
		
		public CmGalleryVo selectGallery(CmGalleryVo vo) {
			return cmGalleryRepository.getOne(vo.getGalleryKey());
		}
		
		public Page<CmGalleryVo> selectGallerys(CmGalleryVo vo, Pageable pageable) {
			return cmGalleryRepository.findAll((Specification<CmGalleryVo>) CommonSpecification.searchWith(vo), pageable);
		}
		
		public CmGalleryVo insertGallery(CmGalleryVo vo) {
			return cmGalleryRepository.save(vo);
		}
		
		public List<CmGalleryVo> insertGallerys(List<CmGalleryVo> entities) {
			return cmGalleryRepository.saveAll(entities);
		}
		
		public CmGalleryVo updateGallery(CmGalleryVo vo) {
			if(cmGalleryRepository.findById(vo.getGalleryKey()).isPresent()) {
				log.info("update");
				return cmGalleryRepository.save(vo);
			}else {
				log.info("inesrt");
				return cmGalleryRepository.save(vo);
			}
			
		}
		
		public List<CmGalleryVo> updateGallerys(List<CmGalleryVo> entities) {
			
			return cmGalleryRepository.saveAll(entities);
		}
		
		public void deleteGallery(CmGalleryVo vo) {
			
			cmGalleryRepository.delete(vo);
		}
		
		public void deleteGallerys(List<CmGalleryVo> entities) {
			
			cmGalleryRepository.deleteAll(entities);
		}
		
		
	
}
