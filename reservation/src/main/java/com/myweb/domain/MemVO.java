package com.myweb.domain;

import java.util.Date;

public class MemVO {
	private int mno;
	private String name;
	private String phonenum;
	private Date regdate;
	
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
	@Override
	public String toString() {
		return "MemVO [mno=" + mno + ", name=" + name + ", phonenum=" + phonenum + ", regdate=" + regdate + "]";
	}
}
