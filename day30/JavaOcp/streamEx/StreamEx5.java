package streamEx;

import java.util.Arrays;
import java.util.List;

public class StreamEx5 {

	public static void main(String[] args) {
		List<Student2> l=Arrays.asList(
				new Student2("a1",80,75,60),
				new Student2("a2",70,85,90),
				new Student2("a3",75,95,65),
				new Student2("a4",65,60,80),
				new Student2("a5",60,70,95),
				new Student2("a6",55,95,75),
				new Student2("a7",85,95,50),
				new Student2("a8",60,60,75)
				);
		
		l
		.stream()
		.sorted((o1,o2)->o1.getSum()-o2.getSum())
		.forEach(s->s.show());

	}

}
