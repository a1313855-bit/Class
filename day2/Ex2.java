class Ex2
{
	public static void main(String[] args)
	{
		//1.整數
		//例:x=10;
		//需要先宣告x在此處的資料類型
		byte x=10;
		//數字預設為int可以強制轉成其他變數		
		
		System.out.println(x);

		//例:byte x2=130;
		//此處的強制將130轉成byte，但byte(-127~126)，並無法找尋到130
		//導致無法得出正確答案
		short x2=130;
		byte x3=(byte)130;
		//所以正確做法為改變左邊的資料類型
		
		System.out.println(x2);
		System.out.println(x3);

		//2.整數資料類型的應用

		/*
		例:
		byte a1=10;
		byte a2=20;
		byte a3=10+20;
		byte a3_2=a1+a2;
		*/
		byte a1=10;
		byte a2=20;
		byte a3=10+20;
		
		//右邊為變數電腦無法直接判斷資料類型，若無指定預設為int
		//如果要令此指令成立
		byte a3_2=(byte)(a1+a2);
		int a3_3=a1+a2;
		//不過若加出的範圍超過byte會得不出正確答案
		//保險作法同上改變左邊的資料類型

		System.out.println(a3_2);
		System.out.println(a3_3);
	}
}