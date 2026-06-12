class Ex3
{
	public static void main(String[] args)
	{
		//浮點數
		//例:float x=10.;
		float x=(float)10.;
		float x2=10.f;//float
		float x3=10.F;//java.lang.Float
		double x4=10.;

		System.out.println(x);
		System.out.println(x2);
		System.out.println(x3);
		System.out.println(x4);

		//字元
		//例:char x5=a
		char x5=65;//ASCII code碼 用來設計鍵盤

		System.out.println(x5);

		//布林值
		boolean x6=true;
		boolean x7=false;

		System.out.println(x6);
		System.out.println(x7);

		//字串
		String x8="abcdef\tghijklmno\npqrstuvwxyz";
		//\t 

		System.out.println(x8);

		//變數命名規則
		int chinese=10;
		int Chinese=10;
		//不能重複單字(大小寫可區分)

		//int static=10;
		//不能使用已有指令的單字

		int abc1=10;
		//int 1abc=10;
		//數字不能放在字首

		int $abc=10;
		int _abc=10;
		//int *abc=10;
		//符號只能使用$或_

		//若想使用句子
		//例:int this is a book=10;

		//1.駝峰命名

		int ThisIsABook=10;//字首大寫=大駝峰
		int thisIsABook=10;//後面的字首大寫=小駝峰

		//2.蛇型
		int this_is_a_book=10;
		//在單字與單字間加入底線

		int 國文=10;
		//也可使用中文為變數
	}
}