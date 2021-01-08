package com.dnd.project.gallery.point.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.dnd.project.common.baseUtill.CommonSpecification;
import com.dnd.project.gallery.point.vo.CmPointVo;

import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
public class CmPointRepositoryImpl{
	@Autowired
	CmPointRepository cmPointRepository;
	
	@Autowired
	CommonSpecification commonSpecification;
	
	public CmPointVo selectPoint(CmPointVo cmPointVo) {
		return cmPointRepository.getOne(cmPointVo.getPointKey());
	}
	
	public Page<CmPointVo> selectPoints(CmPointVo cmPointVo, Pageable pageable) {
		return cmPointRepository.findAll((Specification<CmPointVo>) CommonSpecification.searchWith(cmPointVo), pageable);
	}
	
	public CmPointVo insertPoint(CmPointVo cmPointVo) {
		return cmPointRepository.save(cmPointVo);
	}
	
	public List<CmPointVo> insertPoints(List<CmPointVo> entities) {
		return cmPointRepository.saveAll(entities);
	}
	
	public CmPointVo updatePoint(CmPointVo cmPointVo) {
		if(cmPointRepository.findById(cmPointVo.getPointKey()).isPresent()) {
			log.info("update");
			return cmPointRepository.save(cmPointVo);
		}else {
			log.info("inesrt");
			return cmPointRepository.save(cmPointVo);
		}
		
	}
	
	public List<CmPointVo> updatePoints(List<CmPointVo> entities) {
		
		return cmPointRepository.saveAll(entities);
	}
	
	public void deletePoint(CmPointVo cmPointVo) {
		
		cmPointRepository.delete(cmPointVo);
	}
	
	public void deletePoints(List<CmPointVo> entities) {
		
		cmPointRepository.deleteAll(entities);
	}
	
	
	
	
}
