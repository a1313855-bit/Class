/*
Compiler(編譯器)-->檢查
->java API-->預設位置-->java.lang
->同一位置
*/

import java.util.Scanner;
import java.util.Date;
//import java.util.*;//這樣寫編譯會成功，可是不要這樣寫。Bug修正會變困難。

class Ex1
{
	public static void main(String[] arge){
		Order o1=new Order(10,20);
		java.lang.Thread t=new java.lang.Thread();//絕對路徑
		Thread t2=new Thread();//相對路徑
		java.util.Scanner sc=new java.util.Scanner(System.in);//絕對路徑
		Scanner sc2=new Scanner(System.in);
		//相對路徑,若不是java.lang，class前面import 絕對路徑。
		Date d=new Date();
		System.out.println(d);
	}
}