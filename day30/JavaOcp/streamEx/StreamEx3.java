package streamEx;

import java.util.Arrays;
import java.util.List;

public class StreamEx3 {

	public static void main(String[] args) {
		List<Integer> l=Arrays.asList(10,20,50,30,-5,-25,15,40,75);
		l
		//轉型stream
		.stream()
		//篩選
		.filter(t->t>=25)
		//排列
		.sorted()
		//輸出
		.forEach(t->System.out.print(t+" "));
	}

}
