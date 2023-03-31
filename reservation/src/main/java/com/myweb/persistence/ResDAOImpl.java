package com.myweb.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myweb.domain.MemResVO;
import com.myweb.domain.PageVO;
import com.myweb.domain.ResVO;

@Repository
public class ResDAOImpl implements ResDAO {
	private final String NS = "ResMapper.";
	
	@Autowired
	private SqlSession sql;
	

	@Override
	public int regist(ResVO rvo) {
		return sql.insert(NS + "regist", rvo);
	}

	@Override
	public List<MemResVO> getList() {
		return sql.selectList(NS + "getList");
	}

	@Override
	public int checkDate(String resdate) {
		return sql.selectOne(NS + "checkDate", resdate);
	}

	@Override
	public int totalCount() {
		return sql.selectOne(NS + "totalCount");
	}

	@Override
	public MemResVO getDetail(int rno) {
		return sql.selectOne(NS + "getDetail", rno);
	}

	@Override
	public int delete(int rno) {
		return sql.update(NS + "delete", rno);
	}

	@Override
	public List<MemResVO> getListPaging(PageVO pgvo) {
		return sql.selectList(NS + "getListPaging", pgvo);
	}

	@Override
	public int modify(MemResVO mrvo) {
		return sql.update(NS + "modify", mrvo);
	}

}
