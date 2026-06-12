class Ex3_text
{
	public static void main(String[] args) 
	{
		java.util.Scanner sc=new java.util.Scanner(System.in);
		System.out.println("請輸入國文成績:");
		int chi=sc.nextInt();

		System.out.println("請輸入英文成績:");
		int eng=sc.nextInt();

		System.out.println("\n你的成績:");
		System.out.println("國文:"+chi);
		System.out.println("英文:"+eng);
		System.out.println("總分:"+(chi+eng));
	}
}