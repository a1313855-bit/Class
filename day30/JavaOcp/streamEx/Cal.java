package streamEx;

public class Cal {
	public static int sort_by_sum(Student2 o1, Student2 o2) {
		return o2.getSum() - o1.getSum();
	}

	public static int sort_by_chi(Student2 o1, Student2 o2) {
		return o1.getChi() - o2.getChi();
	}

	public static int sort_by_eng(Student2 o1, Student2 o2) {
		return o1.getEng() - o2.getEng();
	}

	public static int sort_by_math(Student2 o1, Student2 o2) {
		return o1.getMath() - o2.getMath();
	}
}
