package com.myweb.domain;

public class PageVO {
	private int pageNum; // 현재 페이지
	private int amount; // 한 페이지에 보여지는 게시글 수
	
	public PageVO() {
		this(1, 10);
	}
	public PageVO(int pageNum, int amount) { 
		this.pageNum = pageNum;
		this.amount = amount;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "PageVO [pageNum=" + pageNum + ", amount=" + amount + "]";
	}
	
}
