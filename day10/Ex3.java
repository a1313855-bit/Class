class Ex3
{
	public static void main(String[] arge){
		int[] x=new int[]{10,20,30};
		int[] y=new int[]{40,50,60};
		System.out.println("x="+x);
		System.out.println("y="+y);
		System.out.println("x[0]="+x[0]);
		System.out.println("y[0]="+y[0]);
		System.out.println("===============================");
		//x=y;//位址=位址-->同一位址-->被回收消滅-->garbage collection-->GC
		x[0]=y[0];//值=值-->copy
		System.out.println("x="+x);
		System.out.println("y="+y);
		System.out.println("x[0]="+x[0]);
		System.out.println("y[0]="+y[0]);
		System.out.println("===============================");
		x[0]=50;
		System.out.println("x="+x);
		System.out.println("y="+y);
		System.out.println("x[0]="+x[0]);
		System.out.println("y[0]="+y[0]);
	}
}