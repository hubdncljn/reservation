package com.myweb.persistence;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myweb.domain.MemResVO;
import com.myweb.domain.MemVO;

@Repository
public class MemDAOImpl implements MemDAO {
	private final String NS = "MemMapper.";
	
	@Autowired
	private SqlSession sql;
	
	@Override
	public int regist(MemVO mvo) {
		return sql.insert(NS + "regist", mvo);
	}

	@Override
	public int getCurrMno() {
		return sql.selectOne(NS + "getCurrMno");
	}

	@Override
	public int modify(MemResVO mrvo) {
		return sql.update(NS + "modify", mrvo);
	}

	@Override
	public int checkRes(String name, String phonenum) {
		return sql.selectOne(NS + "");
	}

}
