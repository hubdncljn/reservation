package com.myweb.ctrl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myweb.domain.MemVO;
import com.myweb.domain.ResVO;
import com.myweb.persistence.MemDAO;
import com.myweb.persistence.ResDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DBTest {
	private static final Logger logger = LoggerFactory.getLogger(DBTest.class);
	
	@Autowired
	private ResDAO rdao;
	
	@Autowired
	private MemDAO mdao;
	
	/* 등록 테스트 */
	@Test
	public void testRegist() {

		MemVO mvo = new MemVO();
		ResVO rvo = new ResVO();
		mvo.setName("test");
		mvo.setPhonenum("test");
		rvo.setResdate("mtest");
		rvo.setMno(mvo.getMno());

		rdao.regist(rvo);
		mdao.regist(mvo);

	}
	
}
