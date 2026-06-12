class Ex4_text
{
	public static void main(String[] args) 
	{
		java.util.Scanner sc=new java.util.Scanner(System.in);
		System.out.println("請輸入分數");
		int x=sc.nextInt();

		if(x>=60)
		{
			System.out.println("及格\n恭喜你");
		}
		else
		{
			System.out.println("不及格\n再加油");
		}
	}
}