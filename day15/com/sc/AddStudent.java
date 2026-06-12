package com.sc;

import com.sa.Student1;
import com.sa.Student2;
import com.sb.A;
import com.sb.B;

class AddStudent{
	public static void main(String[] args){
		//System.out.println("hello java");->測試

		Student1 s1=new Student1("abc");
		System.out.println(s1.show());

		A a=new A("a",10);
		B b=new B("b",20);
		a.skill();
		b.skill();
	}
}