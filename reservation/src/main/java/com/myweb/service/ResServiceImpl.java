package com.myweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myweb.domain.MemResVO;
import com.myweb.domain.PageVO;
import com.myweb.domain.ResVO;
import com.myweb.persistence.ResDAO;

@Service
public class ResServiceImpl implements ResService {
	
	@Autowired
	private ResDAO rdao;
	
	@Override
	public int regist(ResVO rvo) {
		return rdao.regist(rvo);
	}

	@Override
	public List<MemResVO> getList() {
		return rdao.getList();
	}

	@Override
	public int checkDate(String resdate) {
		return rdao.checkDate(resdate);
	}

	@Override
	public int totalCount() {
		return rdao.totalCount();
	}

	@Override
	public MemResVO getDetail(int rno) {
		return rdao.getDetail(rno);
	}

	@Override
	public int delete(int rno) {
		return rdao.delete(rno);
	}

	@Override
	public List<MemResVO> getListPaging(PageVO pgvo) {
		return rdao.getListPaging(pgvo);
	}

	@Override
	public int modify(MemResVO mrvo) {
		return rdao.modify(mrvo);
	}

}
