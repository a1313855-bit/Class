package arrayEx;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayEx5 {

	public static void main(String[] args) {
		Student2[] s=new Student2[4];
		s[0]=new Student2("a1",60,70,80);
		s[1]=new Student2("a2",65,70,90);
		s[2]=new Student2("a3",80,75,60);
		s[3]=new Student2("a4",70,80,85);
		
		for(Student2 o:s) {
			o.show();
		}
		
		System.out.println("============================");
		
		Comparator<Student2> c=cal::sort_by_chi;
		
		Arrays.sort(s,c);
		
		for(Student2 o:s) {
			o.show();
		}
		

	}

}

class cal{
	public static int sort_by_sum(Student2 o1,Student2 o2) {
		return o2.getSum()-o1.getSum();
	}
	
	public static int sort_by_chi(Student2 o1,Student2 o2) {
		return o1.getChi()-o2.getChi();
	}
	
	public static int sort_by_eng(Student2 o1,Student2 o2) {
		return o1.getEng()-o2.getEng();
	}
	
	public static int sort_by_math(Student2 o1,Student2 o2) {
		return o1.getMath()-o2.getMath();
	}
}
