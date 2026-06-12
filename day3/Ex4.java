class Ex4
{
	public static void main(String[] args)
	{
		java.util.Scanner sc=new java.util.Scanner(System.in);
		System.out.println("請輸入分數");
		int x=sc.nextInt();

		//條件控制 if、else
		if(x>=60)//裡面必須是boolean
		{
			System.out.println("及格");
			System.out.println("恭喜你");
		}
		else
		{
			System.out.println("不及格");
			System.out.println("再加油");
		}

		//三元條件式
		//System.out.pointln(x>=60?"及格，恭喜你":"不及格，再加油");
		//這裡的三元分別是 條件 結果1:結果2
		//?-->if  :-->else

		/*
		if(x>=60) 
		{
			System.out.println("及格");
			System.out.println("恭喜你");
		}
		*/
	}
}