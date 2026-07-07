public class StringApiDemo{
	public static void main(String[] args){
		String name="Allen";
		String keyword=" Java API ";
		/*
		方法: int length()
		用途:取得字串長度->Allen共5個字元
		輸出:5
		*/
		System.out.println(name.length());
		/*
		方法: String trim()
		用途:移除字串前後空格(中間不會移除)
		輸出:Java API
		*/
		System.out.println(keyword.trim());
		/*
		方法: String toLowerCase()
		用途:全部變成小寫
		輸出: java api 
		*/
		System.out.println(keyword.toLowerCase());
		/*
		方法: boolean contains(String str)
		用途:判斷字串裡是否有指定內容
		輸出:true
		*/
		System.out.println(keyword.contains("API"));

		//用途:建立一個可修改字串的物件
		StringBuilder stringBuilder=new StringBuilder();
		/*
		方法: append()
		用途: 把資料接到後面
		*/
		stringBuilder.append("學員:").append(name).append("\n");
		stringBuilder.append("課程:").append(keyword.trim()).append("\n");
		stringBuilder.append("狀態:報名成功");
		/*
		Q:為什麼可以連續使用.append()?
		A:因為.append()會回傳目前這個StringBuilder自己，所以可以連續呼叫(稱為方法鏈(Method Chaining))
		*/

		/*
		方法: String toString()
		用途: 把資料轉成String (StringBuilder並非String物件)
		*/
		System.out.println(stringBuilder.toString());
	}
}