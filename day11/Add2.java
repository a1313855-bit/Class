class Add2
{
	public static void main(String[] args) {
		Member[][] m=new Member[2][2];
		//填入值m[0]
		m[0][0]=new Member("a","台北");
		m[0][1]=new Member("b","台北");
		//填入值m[1]
		m[1][0]=new Member("c","新北");
		m[1][1]=new Member("d","新北");

		//Loop迴圈
		System.out.println(m);
		for(int a=0;a<m.length;a++){
			System.out.println("\t"+m[a]);
			for(int b=0;b<m[a].length;b++)
			{
				System.out.println("\t\t"+m[a][b]+"\t"+m[a][b].show());
			}
		}
		System.out.println("===========================");
		//for-each
		System.out.println(m);
		for(Member[] c:m)
		{
			System.out.println("\t"+c);
			for(Member d:c)
			{
				System.out.println("\t\t"+d+"\t"+d.show());
			}
		}
	}
}