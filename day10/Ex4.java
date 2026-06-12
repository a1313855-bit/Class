class Ex4{
	public static void main(String[] args) {
		//int[] x=new int[3];
		int[] x=new int[]{20,30,40};
		System.out.println(x[0]);
		System.out.println(x[1]);
		System.out.println(x[2]);
		//System.out.println(x[3]);//java陣列個數不會自動增加

		x=new int[10];//這裡是換一個位置取代掉x
		x[3]=70;
		System.out.println(x[0]);
		System.out.println(x[1]);
		System.out.println(x[2]);
		System.out.println(x[3]);
		
	}
}