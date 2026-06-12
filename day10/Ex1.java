//Array 陣列(數組)
class Ex1
{
	public static void main(String[] arge){
		/*
		initialige->0,0,0
		int[] x=new int[3];x[0],x[1],x[2]
		
		initialige->0.0,0.0,0.0
		double[] x=new double[3];
		
		initialige->false,false,false
		boolean[] x=new boolean[3];

		initialige-> , , ;'\u0000'->空字元 看不到東西
		char[] x3=new char[3];

		class類型:initialige->null,null,null
		String[] x=new String[3];
		Double[] x=new Double[3];
		Boolean[] x=new Boolean[3];
		Order[] x=new Order[3];
		*/

		char[] x3=new char[3];
		System.out.println(x3+"\t"+x3[0]+"\t"+x3[1]+"\t"+x3[2]);

		//new先給初始值
		int[] x=new int[3];
		System.out.println(x+"\t"+x[0]+"\t"+x[1]+"\t"+x[2]);
		System.out.println("=================================");
		
		//在自訂其值
		x[0]=10;
		x[1]=20;
		x[2]=30;
		System.out.println(x+"\t"+x[0]+"\t"+x[1]+"\t"+x[2]);
		
		//不用new給初始值
		int[] x2=new int[]{5,10,15};
		System.out.println(x2+"\t"+x2[0]+"\t"+x2[1]+"\t"+x2[2]);


		/*
		int abc=10;
		int dd=20;
		int ee=30;

		System.out.println(abc);
		System.out.println(dd);
		System.out.println(ee);
		*/
	}
}