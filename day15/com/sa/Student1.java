package com.sa;//package 從 com 開始

public class Student1{
	private String name;
	
	public Student1(String name){
		this.name=name;
	}

	public String show(){
		return "名:"+name;
	}
}