import java.util.Scanner;

class Add_Order
{
	public static void main(String[] arge){
		Scanner sc=new Scanner(System.in);
		
		System.out.print("請輸入名稱:");
		String name=sc.next();
		
		System.out.print("請輸入尺的數量:");
		int ruler=sc.nextInt();

		System.out.print("請輸入筆的數量:");
		int pen=sc.nextInt();

		Order o=new Order(name,ruler,pen);
		o.show();

		/*
		Order o1=new Order("abc",1,1);
		Order o2=new Order(1,1);

		o1.show();
		o2.show();
		*/
	}
}