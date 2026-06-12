class Ex2
{
	public static void main(String[] arge){
		//int[] x=new int[3];
		//double[] x=new double[3];
		//String[] x=new String[3];由new給初始值
		String[] x=new String[]{"abc",null,"!@#$%^&*","巨匠電腦","alone","aqua"};

		System.out.println(x+"個數:"+x.length);//.length(陣列內容個數)

		for(int p=0;p<x.length;p++)//.length也可應用在for迴圈的條件中
		{
			System.out.println(x[p]);
		}

		System.out.println("=============================");
		
		for(int i=0;i<3;i++)//指定範圍//此處的int是索引變數的datatype，與陣列無關
		{
			System.out.println(x[i]);
		}

		System.out.println("============================");
		//for(int o:x)//陣列全部資料
		//for(double o:x)//o複製x的陣列內容,datatype要相同
		for(String o:x)
		{
			System.out.println(o);
		}
	}
}