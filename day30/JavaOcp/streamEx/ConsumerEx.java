package streamEx;

import java.util.function.Consumer;

public class ConsumerEx {

	public static void main(String[] args) {
		Consumer<Integer> c=(t)->{
			for(int i=1;i<=t;i++) {
				System.out.println("i:"+i+"\thello java");
			}
		};
		
		c.accept(10);

	}

}
