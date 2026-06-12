class Ex6
{
	public static void main(String[] args)
	{
		//(三)關係運算子
		//-->條件判斷式 boolean 結果true,false
		int chi=65;

		//1.大於
		System.out.println("chi>60----->"+(chi>60));
		//2.大於等於
		System.out.println("chi>=60----->"+(chi>=60));
		//3.小於
		System.out.println("chi<60----->"+(chi<60));
		//4.小於等於
		System.out.println("chi<=60----->"+(chi<=60));
		//5.相等
		System.out.println("chi==60----->"+(chi==60));
		//6.不等
		System.out.println("chi!=60----->"+(chi!=60));

		System.out.println("================================");

		//(四)條件運算子
		//-->多個條件
		int math=65;
		int eng=85;

		//1.and(且)，所有條件必須都是true (可以多條件)
		System.out.println("math>=60 && eng>=80-->"+(math>=60 && eng>=80));
		//2.or(或)，其中有一個條件是true (可以多條件)
		System.out.println("math>=60 || eng>=80-->"+(math>=60 || eng>=80));
		//3.xor(或)，只能有一個條件是true (只能兩個條件)
		System.out.println("math>=60 ^ eng>=80-->"+(math>=60 ^ eng>=80));
		//4.not(不)，把true跟false相反
		System.out.println("math>=60 &&  eng>=80-->"+!(math>=60 && eng>=80));
		//注意括號位置，這裡是先計算完才相反
		System.out.println("math>=60 ^  eng>=80-->"+(!(math>=60) ^ eng>=80));
		//注意括號位置，這裡是math先計算後相反，再把外圈括號的答案輸出
	}
}