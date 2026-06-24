package arrayEx;

import java.util.Arrays;

public class ArreyEx1 {

	public static void main(String[] args) {
		int[] x=new int[] {20,30,10,5,60,-5,35};
		
		for(int o:x) {
			System.out.print(o+" ");
		}
		
		System.out.println("\n============================");
		
		//照順序由小到大
		Arrays.sort(x);		
		for(int o:x) {
			System.out.print(o+" ");
		}
	}

}
