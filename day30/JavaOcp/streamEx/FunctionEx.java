package streamEx;

import java.util.function.Function;

public class FunctionEx {

	public static void main(String[] args) {
		String number="100";
		System.out.println(10+number);
		
		System.out.println("===================");
		
		Function<String,Integer> f=(t)->Integer.parseInt(t);
		System.out.println(10+f.apply(number));
	}

}
