package com.dnd.project.gallery.board.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.dnd.project.common.baseUtill.CommonSpecification;
import com.dnd.project.gallery.board.vo.CmCommentVo;

import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
public class CmCommentRepositoryImpl{
	@Autowired
	CmCommentRepository cmCommentRepository;
	
	@Autowired
	CommonSpecification commonSpecification;
	
	public CmCommentVo selectComment(CmCommentVo vo) {
		return cmCommentRepository.getOne(vo.getCommentKey());
	}
	
	@SuppressWarnings("unchecked")
	public Page<CmCommentVo> selectComments(CmCommentVo vo, Pageable pageable) {
		return cmCommentRepository.findAll((Specification<CmCommentVo>) CommonSpecification.searchWith(vo), pageable);
	}
	
	public CmCommentVo insertComment(CmCommentVo vo) {
		return cmCommentRepository.save(vo);
	}
	
	public List<CmCommentVo> insertComments(List<CmCommentVo> entities) {
		return cmCommentRepository.saveAll(entities);
	}
	
	public CmCommentVo updateComment(CmCommentVo vo) {
		if(cmCommentRepository.findById(vo.getCommentKey()).isPresent()) {
			log.info("update");
			return cmCommentRepository.save(vo);
		}else {
			log.info("inesrt");
			return cmCommentRepository.save(vo);
		}
		
	}
	
	public List<CmCommentVo> updateComments(List<CmCommentVo> entities) {
		
		return cmCommentRepository.saveAll(entities);
	}
	
	public void deleteComment(CmCommentVo vo) {
		
		cmCommentRepository.delete(vo);
	}
	
	public void deleteComments(List<CmCommentVo> entities) {
		
		cmCommentRepository.deleteAll(entities);
	}
	
	
	
	
}
