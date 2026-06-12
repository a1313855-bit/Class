/*設計-購物系統
(一)產品資料
品名:
lcd->4999 
ram->1280
mouse->750
(二)資料庫->表Order
name->String
led->int
ram->int
mouse->int
sum->double
member->int
(三)功能需求
1.輸入(新增)
1)判斷->led,rem,mouse>=0
2)輸入name,led,rem,mouse,member
3)計算折扣->sum>=20000 打95折
         ->是會員打95折(可疊加)
2.輸出
你的購物細目
名:
led:
rem:
mouse:
會員:
金額:
*/
import java.util.Scanner;
class Add_Order
{
	public static void main(String[] arge){
		Scanner sc=new Scanner(System.in);
		//可以先宣告
		//int lcd,ram,mouse,member;
		//String name;

		System.out.print("請輸入名稱:");
		String name=sc.next();

		System.out.print("請輸入lcd數量:");
		int lcd=sc.nextInt();

		System.out.print("請輸入ram數量:");
		int ram=sc.nextInt();

		System.out.print("請輸入mouse數量:");
		int mouse=sc.nextInt();

		System.out.print("是否是會員:\n1)是,2)否");
		int member=sc.nextInt();

		System.out.println("\n");

		Order o=new Order(name,lcd,ram,mouse,member);
		o.show();
	}
}