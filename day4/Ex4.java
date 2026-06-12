class Ex4
//(五)控制loop條件
//1.break 停止
//2.continue 符合條件的不執行
//3.label 指定條件區間(巢狀)(參考:Ex3)
{
	public static void main(String[] arge){
		java.util.Scanner sc=new java.util.Scanner(System.in);
		System.out.print("請輸入數字:");
		int n=sc.nextInt();

		for(int i=1;i<=n;i++)
		{
			//if(i==121) break;
			//if(i==121) continue;
			if(i>=31 && i<=50) continue;
			if(i>=76 && i<=90) continue;
			if(i==131) break;
			System.out.println("i="+i+"\thello java");
		}
	}
}