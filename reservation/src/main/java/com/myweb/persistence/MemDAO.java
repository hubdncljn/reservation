package com.myweb.persistence;

import com.myweb.domain.MemResVO;
import com.myweb.domain.MemVO;

public interface MemDAO {
	public int regist(MemVO mvo); // 등록
	public int getCurrMno(); // 현재 회원 번호 조회
	public int modify(MemResVO mrvo); // 수정
	public int checkRes(String name, String phonenum);
}
