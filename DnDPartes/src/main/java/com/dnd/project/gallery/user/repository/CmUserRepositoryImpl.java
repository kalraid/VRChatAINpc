  package com.dnd.project.gallery.user.repository;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.dnd.project.common.baseUtill.CommonSpecification;
import com.dnd.project.gallery.user.vo.CmUserVo;

import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
public class CmUserRepositoryImpl  {
	@Autowired
	CmUserRepository cmUserRepository;
	
	@Autowired
	CommonSpecification commonSpecification;
	
	public CmUserVo selectUser(CmUserVo cmUserVo) {
		return cmUserRepository.getOne(cmUserVo.getUserKey());
	}
	
	public Page<CmUserVo> selectUsers(CmUserVo cmUserVo, Pageable pageable) throws EntityNotFoundException{
		return cmUserRepository.findAll((Specification<CmUserVo>) CommonSpecification.searchWith(cmUserVo), pageable);
	}
	
	public CmUserVo insertUser(CmUserVo cmUserVo) {
		return cmUserRepository.save(cmUserVo);
	}
	
	public List<CmUserVo> insertUsers(List<CmUserVo> entities) {
		return cmUserRepository.saveAll(entities);
	}
	
	public CmUserVo updateUser(CmUserVo cmUserVo) {
		if(cmUserRepository.findById(cmUserVo.getUserKey()).isPresent()) {
			log.info("update");
			return cmUserRepository.save(cmUserVo);
		}else {
			log.info("inesrt");
			return cmUserRepository.save(cmUserVo);
		}
		
	}
	
	public List<CmUserVo> updateUsers(List<CmUserVo> entities) {
		
		return cmUserRepository.saveAll(entities);
	}
	
	public void deleteUser(CmUserVo cmUserVo) {
		
		cmUserRepository.delete(cmUserVo);
	}
	
	public void deleteUsers(List<CmUserVo> entities) {
		
		cmUserRepository.deleteAll(entities);
	}
	
	
	
	
}
