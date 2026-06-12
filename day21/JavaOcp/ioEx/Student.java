package ioEx;

import java.io.Serializable;

public class Student implements Serializable {
	private String name;
	private int chi;
	private int eng;
	private int sum;

	public Student(String name, int chi, int eng) {
		super();
		this.name = name;
		this.chi = chi;
		this.eng = eng;
		sum = chi + eng;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getChi() {
		return chi;
	}

	public void setChi(int chi) {
		this.chi = chi;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public void show() {
		System.out.println("名:" + name + "\t國文:" + chi + "\t英文:" + eng + "\t總分:" + sum);
	}

}
