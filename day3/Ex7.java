class Ex7//設計一程式，數入整數，判斷奇數或偶數
{
	public static void main(String[] args)
	{
		java.util.Scanner sc=new java.util.Scanner(System.in);
		//System.out.println("請輸入一組整數");
		System.out.print("請輸入一組整數:");
		//只輸入print後面輸出的文字就不會跑到下一行
		int n=sc.nextInt();

		if(n%2==0)
		{
			if(n>=0)
				{
					System.out.println("正偶數");
				}
			else
				{
					System.out.println("負偶數");
				}	
		}
		else
		{
			if(n>=0)
				{
					System.out.println("正奇數");
				}
			else
				{
					System.out.println("負奇數");
				}
		}
	}
}