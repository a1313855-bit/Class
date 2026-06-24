package arrayEx;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayEx3 {

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
		
		//假設無原始碼的情況 在main程式 Comparator
		Comparator<Student2> c=new Comparator<>() {
			@Override
			public int compare(Student2 o1, Student2 o2) {
				
				return o1.getSum()-o2.getSum();
			}};
	
		Arrays.sort(s,c);
		
		for(Student2 o:s) {
			o.show();
		}
	}
}
