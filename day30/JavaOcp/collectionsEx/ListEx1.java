package collectionsEx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListEx1 {

	public static void main(String[] args) {
		List<Integer> l=new ArrayList<>();
		l.add(10);
		l.add(5);
		l.add(-15);
		l.add(30);
		
		for(Integer o:l) {
			System.out.print(o+" ");
		}
		
		System.out.println("\n======================");
		
		Collections.sort(l);
		
		for(Integer o:l) {
			System.out.print(o+" ");
		}
		
		

	}

}
