class Add3
{
	public static void main(String[] args) {
		Member[][][] m=new Member[3][][];

		//m[0]
		m[0]=new Member[2][];
		m[0][0]=new Member[2];
		m[0][1]=new Member[3];

		//m[1]
		m[1]=new Member[4][];
		m[1][0]=new Member[2];
		m[1][1]=new Member[3];
		m[1][2]=new Member[4];
		m[1][3]=new Member[2];

		//m[2]
		m[2]=new Member[3][];
		m[2][0]=new Member[2];
		m[2][1]=new Member[3];
		m[2][2]=new Member[4];

		//填入值
		m[0][0][0]=new Member("000","台北");
		m[0][0][1]=new Member("001","台北");

		m[0][1][0]=new Member("010","台北");
		m[0][1][1]=new Member("011","台北");
		m[0][1][2]=new Member("012","台北");

		m[1][0][0]=new Member("100","台北");
		m[1][0][1]=new Member("101","台北");

		m[1][1][0]=new Member("110","台北");
		m[1][1][1]=new Member("111","台北");
		m[1][1][2]=new Member("112","台北");

		m[1][2][0]=new Member("120","台北");
		m[1][2][1]=new Member("121","台北");
		m[1][2][2]=new Member("122","台北");
		m[1][2][3]=new Member("123","台北");

		m[1][3][0]=new Member("130","台北");
		m[1][3][1]=new Member("131","台北");

		m[2][0][0]=new Member("200","台北");
		m[2][0][1]=new Member("201","台北");

		m[2][1][0]=new Member("210","台北");
		m[2][1][1]=new Member("211","台北");
		m[2][1][2]=new Member("212","台北");

		m[2][2][0]=new Member("220","台北");
		m[2][2][1]=new Member("221","台北");
		m[2][2][2]=new Member("222","台北");
		m[2][2][3]=new Member("223","台北");

		//Loop迴圈
		System.out.println(m);//位址
		for(int a=0;a<m.length;a++)
		{
			System.out.println("\t"+m[a]);//第一層位址
			for(int b=0;b<m[a].length;b++)
			{
				System.out.println("\t\t"+m[a][b]);//第二層位址
				for(int c=0;c<m[a][b].length;c++)
				{
					System.out.println("\t\t\t"+m[a][b][c]+"\t"+m[a][b][c].show());//第三層位址,值
				}
			}
		}
		System.out.println("===========================");
		
		//for-each
		System.out.println(m);//位址
		for(Member[][] d:m)
		{
			System.out.println("\t"+d);//第一層位址
			for(Member[] e:d)
			{
				System.out.println("\t\t"+e);//第二層位址
				for(Member f:e)
				{
					System.out.println("\t\t\t"+f+"\t"+f.show());//第三層位址,值
				}
			}
		}
	}
}