package com.myweb.service;

import java.util.List;

import com.myweb.domain.MemResVO;
import com.myweb.domain.PageVO;
import com.myweb.domain.ResVO;

public interface ResService {
	public int regist(ResVO rvo); // 등록
	public List<MemResVO> getList(); // 목록 조회
	public int checkDate(String resdate); // 예약 가능여부 체크
	public int totalCount(); // 총 예약 수
	public MemResVO getDetail(int rno); // 상세 조회
	public int delete(int rno); // 에약 취소
	public List<MemResVO> getListPaging(PageVO pgvo); // 목록 조회 (페이징)
	public int modify(MemResVO mrvo);
}
