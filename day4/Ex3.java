class Ex3
//(四)巢狀loop
//-->99乘法表
/*原本的寫法
{
	public static void main(String[] arge){
		int x1=1;
		for(int y=1;y<=9;y++)
		{
			System.out.print(x1+"*"+y+"="+(x1*y)+"\t");
		}
		System.out.println();//這個可以當作換行

		int x2=1;
		for(int y=1;y<=9;y++)
		{
			System.out.print(x2+"*"+y+"="+(x2*y)+"\t");
		}
		System.out.println();

		int x3=1;
		for(int y=1;y<=9;y++)
		{
			System.out.print(x3+"*"+y+"="+(x3*y)+"\t");
		}
		System.out.println();
	}
}
*/
//因為都有規律可以使用巢狀拚再一起
/*{
	public static void main(String[] args) {		
		for(int x=1;x<=9;x++)
		{
			for(int y=1;y<=9;y++)
			{
				System.out.print(x+"*"+y+"="+(x*y)+"\t");
			}
			System.out.println();
		}
	}	
}
*/

{
	public static void main(String[] args) {		
		java.util.Scanner sc=new java.util.Scanner(System.in);
		System.out.print("請輸入列數:");
		int n=sc.nextInt();

		System.out.print("請輸入行數:");
		int m=sc.nextInt();

		a://laber(指定條件區間) //注意:laber的指定範圍必須寫在for的上面一行
		for(int x=1;x<=n;x++)//列數
		{
			//if(x==7) break
			
			b://這裡因為是最內圈所以不寫也沒關係
			for(int y=1;y<=m;y++)//行數
			{
				if(y==8) break;//這裡可以加上b也可以不加
				if(x==7) break a;//把這行的break套用在a:的區間
				System.out.print(x+"*"+y+"="+(x*y)+"\t");
			}
			System.out.println();
		}
	}	
}

//(五)控制loop條件
//1.break 停止
//2.continue 符合條件的不執行
//3.label 指定條件區間(巢狀)