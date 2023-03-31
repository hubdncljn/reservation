package com.myweb.domain;

import java.util.Date;

public class ResVO {
	private int rno;
	private int mno;
	private String resdate;
	private Date regdate;
	
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getResdate() {
		return resdate;
	}
	public void setResdate(String resdate) {
		this.resdate = resdate;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "ResVO [rno=" + rno + ", mno=" + mno + ", regdate=" + regdate + ", resdate=" + resdate + "]";
	}
}
