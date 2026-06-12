//Array陣列(多維陣列)(對稱)
class Ex2
{
	public static void main(String[] args) {
		int[][][] x=new int[2][2][3];
		System.out.println(x);//位址
		System.out.println("\t"+x[0]);//位址第一層
		System.out.println("\t\t"+x[0][0]);//位址第二層
		System.out.println("\t\t\t"+x[0][0][0]);//值

		System.out.println("==============================");
		System.out.println(x);//位址
		for(int a=0;a<x.length;a++)
		{
			System.out.println("\t"+x[a]);//位址第一層
			for(int b=0;b<x[a].length;b++)
				{
					System.out.println("\t\t"+x[a][b]);//位址第二層
					for(int c=0;c<x[a][b].length;c++)
					{
						System.out.println("\t\t\t"+x[a][b][c]);//值
					}
				}
		}
		System.out.println("==============================");
		//for-each
		System.out.println(x);//位址
		for(int[][] d:x)//要copy資料的Datatype要一致
		{
			System.out.println("\t"+d);//位址第一層
			for(int[] e:d)//要copy資料的Datatype要一致
			{
				System.out.println("\t\t"+e);//位址第二層
				for(int f:e)
				{
					System.out.println("\t\t\t"+f);//值
				}
			}
		}
	}
}