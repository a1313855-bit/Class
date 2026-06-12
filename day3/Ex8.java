class Ex8
//學校:設計是否錄取的程式，考試科目:國、英、數，功能需求
//1.輸入科目分數 
//2.錄取條件2階段 A.總分須滿200 B.數學必須至少有75 才能錄取
//3.結果要有三種 A.錄取 B.總分不錄取 C.數學未滿不錄取
{
	public static void main(String[] args) 
	{
		java.util.Scanner sc=new java.util.Scanner(System.in);
		System.out.print("請輸入國文分數:");
		int chinese=sc.nextInt();
		System.out.print("請輸入英文分數:");
		int english=sc.nextInt();
		System.out.print("請輸入數學分數:");
		int math=sc.nextInt();

		if((chinese+english+math)>=200)//sum=chi+eng+math;//可以先加在套入
			{
				if(math>=75)
				{
					System.out.println("錄取");//可以寫得更詳細
				/*
				System.out.println(
				"國文:"+chi+
				"\t英文:"+eng+
				"\t數學:"+math+
				"\t總分:"+sum+
				"\t恭喜錄取");
				*/
				}
				else
				{
					System.out.println("因數學未達75，不錄取");
				}
			}
		else
			{
				System.out.println("因總分未達200，不錄取");
			}
	}
}

//老師解答
/*
{
	public static void main(String[] args) {
		java.util.Scanner sc=new java.util.Scanner(System.in);
		int chi,eng,math,sum;
		System.out.print("請輸入國文:");
		chi=sc.nextInt();

		System.out.print("請輸入英文:");
		eng=sc.nextInt();

		System.out.print("請輸入數學:");
		math=sc.nextInt();

		sum=chi+eng+math;

		if(sum>=200)
		{
			if(math>=75)
			{
				System.out.println(
				"國文:"+chi+
				"\t英文:"+eng+
				"\t數學:"+math+
				"\t總分:"+sum+
				"\t恭喜錄取");
			}
			else
			{
				System.out.println(
				"國文:"+chi+
				"\t英文:"+eng+
				"\t數學:"+math+
				"\t總分:"+sum+
				"\t數學未滿75,不予錄取");
			}
		}
		else
		{
			System.out.println(
				"國文:"+chi+
				"\t英文:"+eng+
				"\t數學:"+math+
				"\t總分:"+sum+
				"\t總分未滿200,不予錄取");
		}
	}
}
*/