package streamEx;

import java.util.Arrays;
import java.util.List;

public class StreamEx4 {

	public static void main(String[] args) {
		List<Student> l=Arrays.asList(
				new Student("a1",80,75,60),
				new Student("a2",70,85,90),
				new Student("a3",75,95,65),
				new Student("a4",65,60,80),
				new Student("a5",60,70,95),
				new Student("a6",55,95,75),
				new Student("a7",85,95,50),
				new Student("a8",60,60,75)
				);
		
		l
		.stream()
		.filter(t->t.getSum()>=200 && t.getSum()<=230)
		.sorted()
		.forEach(t->t.show());

	}

}
