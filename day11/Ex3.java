//Array陣列(多維陣列)(非對稱)
class Ex3
{
	public static void main(String[] args) {
		//第一層
		int[][] x=new int[2][];
		//第二層
		x[0]=new int[3];
		x[1]=new int[4];

		System.out.println(x);//位址
		for(int a=0;a<x.length;a++)
		{
			System.out.println("\t"+x[a]);//第一層位址
			for(int b=0;b<x[a].length;b++)
			{
				System.out.println("\t\t"+x[a][b]);//值
			}
		}
		System.out.println("=================================");
		//for-each
		System.out.println(x);//位址
		for(int[] c:x)
		{
			System.out.println("\t"+c);//第一層位址
			for(int d:c)
			{
				System.out.println("\t\t"+d);//值
			}
		}
	}
}