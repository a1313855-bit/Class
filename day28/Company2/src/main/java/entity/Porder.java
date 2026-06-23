package entity;

import java.io.Serializable;

public class Porder implements Serializable{
	private int id;
	private String name;
	private String desk;
	private int a;
	private int b;
	private int c;
	private int sum;
	
	public Porder() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Porder(String name, String desk, int a, int b, int c) {
		super();
		this.name = name;
		this.desk = desk;
		this.a = a;
		this.b = b;
		this.c = c;
		sum=a*120+b*135+c*150;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesk() {
		return desk;
	}
	public void setDesk(String desk) {
		this.desk = desk;
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	public int getC() {
		return c;
	}
	public void setC(int c) {
		this.c = c;
	}
	public int getSum() {
		sum=a*120+b*135+c*150;
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	
	
}
