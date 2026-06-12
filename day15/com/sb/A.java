package com.sb;

import com.sa.Student1;
import com.sa.Student2;

public class A extends Student1 implements Student2{
	private int chi;

	public A(String name,int chi){
		super(name);
		this.chi=chi;
	}

	public void skill(){
		System.out.println("A skill");
	}
}