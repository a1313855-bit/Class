package collectionsEx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListEx2 {

	public static void main(String[] args) {
		List<Student> l=new ArrayList<>();
		l.add(new Student("a1",65,75,80));
		l.add(new Student("a2",70,95,60));
		l.add(new Student("a3",75,80,85));
		l.add(new Student("a4",85,60,70));
		
		for(Student o:l) {
			o.show();
		}
		
		System.out.println("===================");
		
		Collections.sort(l);
		
		for(Student o:l) {
			o.show();
		}
	}

}
