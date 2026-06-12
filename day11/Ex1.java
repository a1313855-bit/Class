//Array列陣(樹狀結構分組)
class Ex1
{
	public static void main(String[] args) {
		/*
		int[] x=new int[3];
		int[] y=new int[3];
		*/
		//合併		
		/*
		int[][] x=new int[2][3];
		x[0][0]=10;
		*/
		//int[][] x=new int[][]{{10,20,30},{40,50,60}};		
		int[][] x=new int[][]
		{
			{10,20,30},
			{40,50,60}
		};

		System.out.println(x);//位址
		System.out.println("\t"+x[0]);//位址
		System.out.println("\t\t"+x[0][0]);//值
		System.out.println("\t"+x[1]);//位址
		System.out.println("\t\t"+x[1][0]);//值
		System.out.println("====================================");

		System.out.println(x.length);
		System.out.println(x[0].length);
		//System.out.println(x[0][0].length);.length前面是位址
		
		System.out.println("====================================");
		
		System.out.println(x);//位址
		for(int i=0;i<x.length;i++)//拆解第一層位址
		{
			System.out.println("\t"+x[i]);
			for(int j=0;j<x[i].length;j++)//拆解第二層值
			{
				System.out.println("\t\t"+x[i][j]);
			}
		}

		System.out.println("====================================");

		//for-each
		for(int[] o:x)//拆解第一層位址
		{
			System.out.println("\t"+o);//拆解第二層值
			for(int u:o)
			{
				System.out.println("\t\t"+u);
			}
		}
	}
}