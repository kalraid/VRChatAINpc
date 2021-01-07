package com.dnd.party.search.service;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dnd.project.common.user.repository.CmUserRepository;
import com.dnd.project.common.user.vo.CmUserVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class) 
@SpringBootTest              
@Transactional
public class jpaTest {

	@Autowired 
	CmUserRepository repo;
	
    @Autowired
    EntityManager em;
		
	@Test
	public void test() {

		CmUserVo cmUser = CmUserVo.builder().build();
		cmUser.setId("kimire");
		cmUser.setAlias("kim");
		cmUser.setEmail("1123@1232");
		cmUser.setName("1234");
		cmUser.setPassword("1212321");
		log.info(cmUser.toString());
		repo.save(cmUser);
		repo.findAll().forEach( o -> log.info(o.toString()));
//		log.info(repo.findById(1).toString());
		log.info("123");
	}
}
