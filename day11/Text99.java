import java.util.Scanner;
class Text99
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("請輸入被乘數:");
		int x=sc.nextInt();
		System.out.print("請輸入乘數:");
		int y=sc.nextInt();
		for(int a=0;a<=x;a++)
		{
			System.out.println("");
			for(int b=1;b<=y;b++)
			{
				int c=a*b;
				System.out.print(a+"*"+b+"="+c+"\t");
			}
		}
	}
}