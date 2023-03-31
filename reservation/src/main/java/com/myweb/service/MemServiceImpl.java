package com.myweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myweb.domain.MemResVO;
import com.myweb.domain.MemVO;
import com.myweb.persistence.MemDAO;

@Service
public class MemServiceImpl implements MemService {

	@Autowired
	private MemDAO mdao;
	
	@Override
	public int regist(MemVO mvo) {
		return mdao.regist(mvo);
	}

	@Override
	public int getCurrMno() {
		return mdao.getCurrMno();
	}

	@Override
	public int modify(MemResVO mrvo) {
		return mdao.modify(mrvo);
	}

}
