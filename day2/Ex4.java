class Ex4
{
	public static void main(String[] args)
	{
		//(一)算數運算
		int x=10;
		int y=3;

		//1.加法
		System.out.println(x+"+"+y+"="+(x+y));
		//得出10+3=13
		
		//2.減法
		System.out.println(x+"-"+y+"="+(x-y));
		//得出10-3=7
		
		//3.乘法
		System.out.println(x+"*"+y+"="+(x*y));
		//得出10*3=30

		//4.除法
		System.out.println(x+"/"+y+"="+(x/y));
		//得出10/3=3
		//這裡因為x和y是int所以答案得出也會是int的型態
		
		System.out.println(x+"/"+y+"="+((float)x/y));
		//得出10/3=3.3333333
		//如果想要有小數，必須把答案處的x和y變成浮點數再進行運算
		
		System.out.println(x+"/"+y+"="+(float)(x/y));
		//得出10/3=3.0
		//如果寫成這樣，由於括號會先運算的原因，x/y會先進行運算，接著才會轉換成浮點數
		
		//5.餘數
		System.out.println(x+"%"+y+"="+(x%y));
		//得出10%3=1

		System.out.println("=====================");//分隔線

		//(二)指定運算
		
		//指定 = 的應用
		int a=10;
		int b=20;

		//2*a+b=3*a-b;
		//程式語言無法進行這種運算
		//左邊為變數，右邊為計算

		a=2*b+10;

		System.out.println("a="+a+"\tb="+b);
		//得出a=50 b=20
		
		System.out.println("=====================");//分隔線

		//1.前一次增(遞增)
		int abc=10;
		//此時的abc為10
		abc=abc+20;
		//此時先計算右邊，abc還未經過計算所以還是10
		//右邊計算完為30後帶到左邊的abc

		System.out.println("abc="+abc);
		//得出abc=30

		int ThisIsABook=10;

		//ThisIsABook=ThisIsABook+30;
		ThisIsABook+=30;
		System.out.println("ThisIsABook="+ThisIsABook);

		//2.前一次減(遞減)
		//ThisIsABook=ThisIsABook-30;
		ThisIsABook-=30;
		System.out.println("ThisIsABook="+ThisIsABook);

		//3.前一次乘
		//ThisIsABook=ThisIsABook*30;
		ThisIsABook*=30;
		System.out.println("ThisIsABook="+ThisIsABook);

		//4.前一次除
		//ThisIsABook=ThisIsABook/30;
		ThisIsABook/=30;
		System.out.println("ThisIsABook="+ThisIsABook);


		//5.前一次餘數
		//ThisIsABook=ThisIsABook%3;
		ThisIsABook%=3;
		System.out.println("ThisIsABook="+ThisIsABook);



	}
}