package com.example.model;

public class User {

	String ename;
	
	
	public String getEname() {
		return ename;
	}
	
	public void setEname(String ename) {
		this.ename = ename;
	}
	
	@Override
	public String toString() {
	 
		return "My Name Is:-    "+ename;
	}
	
}
