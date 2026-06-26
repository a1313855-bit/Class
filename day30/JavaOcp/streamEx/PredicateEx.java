package streamEx;

import java.util.function.Predicate;

public class PredicateEx {

	public static void main(String[] args) {
		Predicate<Integer> p=(t)->t>0;
		
		if(p.test(0)) {
			System.out.println("yes");
		}else {
			System.out.println("no");
		}

	}

}
