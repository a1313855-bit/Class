package arrayEx;

public class Student implements Comparable<Student>{
	// field
	private String name;
	private int chi;
	private int eng;
	private int math;
	private int sum;

	// constructor
	public Student(String name, int chi, int eng, int math) {
		super();
		this.name = name;
		this.chi = chi;
		this.eng = eng;
		this.math = math;
		sum = chi + eng + math;
	}

	// mathod
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

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getSum() {
		sum = chi + eng + math;
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public void show() {
		System.out.println("名稱:" + name + "\t國文:" + chi + "\t英文:" + eng + "\t數學:" + math + "\t總分:" + getSum());
	}

	@Override
	public int compareTo(Student o) {
		//sum由小到大
		//this拿原本的 - o下一個
		return this.sum-o.sum;
		
		//sum由大到小
		//o下一個 - this拿原本的
		//return o.sum-this.sum;
	}
}
