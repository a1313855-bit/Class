//Array陣列(多維陣列)(非對稱)
class Ex4
{
	public static void main(String[] args) {
		//第一層
		int[][][] x=new int[2][][];//x[0],x[1]
		//第二層[0]
		x[0]=new int[2][];//x[0][0],x[0][1]
		//第三層[0]
		x[0][0]=new int[2];
		x[0][1]=new int[3];
		//第二層[1]
		x[1]=new int[3][];//x[1][0],x[1][1]
		//第三層[1]
		x[1][0]=new int[2];
		x[1][1]=new int[3];
		x[1][2]=new int[4];

		System.out.println(x);
		for(int a=0;a<x.length;a++)
			{
				System.out.println("\t"+x[a]);
				for(int b=0;b<x[a].length;b++)
				{
					System.out.println("\t\t"+x[a][b]);
					for(int c=0;c<x[a][b].length;c++)
					{
						System.out.println("\t\t\t"+x[a][b][c]);
					}
				}
			}
		System.out.println("====================================");
		//for-each
		System.out.println(x);
		for(int[][] d:x)
		{
			System.out.println("\t"+d);
			for(int[] e:d)
			{
				System.out.println("\t\t"+e);
				for(int f:e)
				{
					System.out.println("\t\t\t"+f);
				}
			}
		}
	}
}