class Ex3
{
	public static void main(String[] args) 
	{
		java.util.Scanner sc=new java.util.Scanner(System.in);
		System.out.println("請輸入國文成績:");
		int chi=sc.nextInt();

		System.out.println("請輸入英文成績:");
		int eng=sc.nextInt();

		System.out.println("\n你的成績:\n國文:"+chi+"\n英文:"+eng+"\n總分:"+(chi+eng));
		//利用\n來排版分行
	}
}