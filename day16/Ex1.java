import java.util.Scanner;
import java.util.InputMismatchException;

class Ex1{
	public static void main(String[] args){
		//Error
		/*
		嚴重錯誤，會強制中斷程式

		int x;->x沒給值
		System.out.println("x="+x);->這裡 x 找不到初始值->Error
		->中斷程式
		
		即使下面是對的也無法運行
		for(int i=1;i<=10;i++){
			System.out.println("hello java");
		}
		*/

		//Exception->語法沒問題，執行時出錯
		Scanner sc=new Scanner(System.in);
		int[] x=new int[3];
		System.out.print("請輸入索引碼:");
		System.out.println("");
		

		try{
			int n=sc.nextInt();//不能輸入浮點數
			x[n]=100;//輸入不符合陣列的整數
			//new ArrayIndexOutOfBoundsException();
			System.out.print("請輸入一個分母:");
			//new ArithmeticException
			int m=sc.nextInt();//分母不能為0

			System.out.println("x["+n+"]/"+m+"="+(x[n]/m));
		}		

		//單項捕捉 特別拉出來catch
		catch(ArrayIndexOutOfBoundsException e){//ArrayIndexOutOfBoundsException e=?
			System.out.println("重新輸入，範圍0~2");
			e.printStackTrace();//顯示錯誤訊息
		}

		catch(ArithmeticException e){
			System.out.println("分母不能為0");
			e.printStackTrace();//顯示錯誤訊息
		}
		
		//因為這個不是java.lang 或 同個資料夾的內容 要記得import
		catch(InputMismatchException e){//InputMismatchException e=? 
			System.out.println("請輸入整數");
			e.printStackTrace();//顯示錯誤訊息

		}

		//直接輸入super類別 多項捕捉
		catch(RuntimeException e){//RuntimeException(super) e=?()sub 異質宣告應用
			System.out.println("重新輸入");
			e.printStackTrace();//顯示錯誤訊息
		}
		//單向捕捉和多項捕捉可以同時使用，"多項捕捉要放在後面"

		/*
		//使用此方法sub 跟 super不能寫在一起
		//sub類別
		catch(ArrayIndexOutOfBoundsException|ArithmeticException|InputMismatchException e){
			System.out.println("重新輸入，範圍0~2 or 整數 and 分母不能為0");
		}

		//super類別
		catch(RuntimeException e){
			System.out.println("重新輸入");
		}
		*/

		//finally 即使錯誤也要執行 "java7 以前"
		/*
		finally{
			for(int i=1;i<=10;i++){
				System.out.println("hello java");
		}
		*/

		//java8 以後的版本只需要直接寫在最下面就可以(前提是不會互相影響) 
		for(int i=1;i<=10;i++){
				System.out.println("hello java");
		}
		
	}
}