package streamEx;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamEx2 {

	public static void main(String[] args) {
		List<Integer> l=Arrays.asList(10,20,50,30,-5,-25);
		Stream<Integer> s=l.stream();
		/*
		Consumer<Integer> c=(t)->System.out.print(t+" ");
		s.forEach(c);
		*/
		
		s.forEach(t->System.out.println("number:"+t));
	}

}
