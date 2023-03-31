package com.myweb.domain;

import java.util.Date;

public class MemResVO {
	private int mno;
	private String name;
	private String phonenum;
	private Date regdate;
	private int rno;
	private String resdate;
	
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getResdate() {
		return resdate;
	}
	public void setResdate(String resdate) {
		this.resdate = resdate;
	}
	@Override
	public String toString() {
		return "MemResVO [mno=" + mno + ", name=" + name + ", phonenum=" + phonenum + ", regdate=" + regdate + ", rno="
				+ rno + ", resdate=" + resdate + "]";
	}
	
}
