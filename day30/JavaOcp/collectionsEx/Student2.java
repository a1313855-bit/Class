package collectionsEx;

public class Student2 {
	// field
		private String name;
		private int chi;
		private int eng;
		private int math;
		private int sum;

		// constructor
		public Student2(String name, int chi, int eng, int math) {
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
}
