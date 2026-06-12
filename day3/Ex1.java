class Ex1
{
	public static void main(String[] args)
	{
		//(五)位元運算子
		//-->&、|、^、~(補數)
		int chi=65;
		int eng=75;

		System.out.println(chi>=60 && eng>=80);//必須兩邊都是boolean
		//T && F--->F
		System.out.println(chi>=60 & eng>=80);//兩邊資料類型相同就可以
		//T & F-->1 & 0-->0-->F
		//&使用的是2進位運算

		System.out.println(5&2);
		/*  2進位運算
		5--->0000,0101
		2--->0000,0010 (&
		__________________
		     0000,0000
		    Ans:0
		*/
		System.out.println(5|2);
		/*  2進位運算
		5--->0000,0101
		2--->0000,0010 (|
		__________________
		     0000,0111
		    Ans:7
		*/
		System.out.println(5^7);
		/*  2進位運算
		5--->0000,0101
		7--->0000,0111 (^
		__________________
		     0000,0010
		    Ans:2
		*/

		System.out.println(5);
		/*  2進位運算
		5--->0000,0101
		    Ans:5
		*/
		System.out.println(~5);
		/*  2進位運算
		5--->0000,0101 (~
		     1111,1010
		    Ans:-6
		使用了補數的概念
		0-->0000,0000 -1-->1111,1111
		1-->0000,0001 -2-->1111,1110
		2-->0000,0010 -3-->1111,1101

		*/
		System.out.println(~(-4));
		//Ans:3

		//(六)位碼運算子
		//--> >>(右移)、<<(左移)
		System.out.println(5>2);
		//boolean之間的運算
		//
		
		System.out.println(5>>2);
		/*  2進位運算
		5--->0000,0101 (>>
		     0000,0001
		    Ans:1

		*/
		System.out.println(5<<2);
		/*  2進位運算
		5--->0000,0101 (<<
		     0001,0100
		    Ans:20

		*/
		
		//這裡的運算符號也適用於day2的運算方法
		//chi=chi>>2;
		chi>>=2;
		System.out.println(chi);

	}
}