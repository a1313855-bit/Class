public class LongApiDemo{
	public static void main(String[] args){
		//目前是String
		String qtyText = "3";
		String priceText = "99.5";

		//===========Integer API===========//

		/*
		方法: Integer.parseInt(String s)
		用途: 把String轉成Integer
		*/
		int qty = Integer.parseInt(qtyText);
		

		//===========Double API===========//

		/*
		方法: Double.parseDouble(String s)
		用途: 把String轉成Double
		*/
		double price = Double.parseDouble(priceText);
		/*
		Q:這兩種方法如果轉型的字串不是數字->"ABC"
		A:輸出NumberFormatException
		*/

		double total = qty+price;

		System.out.println("數量="+qty);
		System.out.println("總金額="+total);
		
		//===========Math API===========//

		/*
		方法: long Math.round(double value)
		用途: 四捨五入
		*注意: 回傳類別 long 
		*/
		System.out.println("四捨五入="+Math.round(total));
		
		/*
		方法: Math.max(a,b)
		用途: 回傳兩個數中比較大的
		補充: Math.min(a,b) -> 回傳比較小的
		*/
		System.out.println("最大值="+Math.max(80,95));

		//===========System API===========//
		
		/*
		方法: long System.currentTimeMillis()
		用途: 取得目前時間(毫秒)
		*/
		System.out.println("目前時間毫秒="+System.currentTimeMillis());

		/*
		應用(一):
		計算程式執行時間
		*/
		long start = System.currentTimeMillis();
		// 做很多事情
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		//假設輸出 125 -> 花了125毫秒

		/*
		應用(二):
		產生唯一流水號->因為幾乎不會重複
		*/
		System.out.println(System.currentTimeMillis());

		/*
		應用(三):
		記錄登入時間
		*/

		//補充:這些方法全部都是static->不需要先建立物件，可直接用「類別名稱.方法名稱」呼叫。
	}
}