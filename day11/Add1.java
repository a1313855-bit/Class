class Add1
{
	public static void main(String[] args) {
		Member[] m=new Member[3];//m[0],m[1],m[2]-->設定編號，還沒有值。
		System.out.println(m);
		System.out.println(m[0]);
		System.out.println(m[1]);
		System.out.println(m[2]);
		System.out.println("==============================");
		//填入值
		m[0]=new Member("a","台北市");
		m[1]=new Member("b","高雄");
		m[2]=new Member("c","基隆");

		System.out.println(m[0]+"\t"+m[0].show());
		System.out.println(m[1]+"\t"+m[1].show());
		System.out.println(m[2]+"\t"+m[2].show());
		System.out.println("==============================");
		//Loop迴圈
		System.out.println(m);
		for(int a=0;a<m.length;a++)
		{
			System.out.println("\t"+m[a]+"\t"+m[a].show());
		}
		System.out.println("==============================");
		//for-each
		System.out.println(m);
		for(Member b:m)
		{
			System.out.println("\t"+b+"\t"+b.show());
		}

		/*三筆資料利用Member
		Member a=new Member("a","台北市");
		Member b=new Member("b","台北市");
		Member c=new Member("c","台北市");

		a.show();
		b.show();
		c.show();
		*/
	}
}