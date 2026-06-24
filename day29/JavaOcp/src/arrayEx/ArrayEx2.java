package arrayEx;

import java.util.Arrays;

public class ArrayEx2 {

	public static void main(String[] args) {
		Student[] s=new Student[4];
		s[0]=new Student("a1",60,70,80);
		s[1]=new Student("a2",65,70,90);
		s[2]=new Student("a3",80,75,60);
		s[3]=new Student("a4",70,80,85);
		
		for(Student o:s) {
			o.show();
		}
		
		System.out.println("============================");
		
		//有原始碼(Student)的情況下 去源頭的物件裡 Comparable
		Arrays.sort(s);
		for(Student o:s) {
			o.show();
		}
	}

}
