package collectionsEx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListEx4 {
	public static void main(String[] args) {
		List<Student2> l=new ArrayList<>();
		l.add(new Student2("a1",65,75,80));
		l.add(new Student2("a2",70,95,60));
		l.add(new Student2("a3",75,80,85));
		l.add(new Student2("a4",85,60,70));

		for(Student2 o:l) {
			o.show();
		}
		
		System.out.println("============================================");
		
		Collections.sort(l,Cal::sort_by_sum);
		
		for(Student2 o:l) {
			o.show();
		}
	}
}
