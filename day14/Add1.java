//異質宣告
//編譯 從右找到左
//執行 從左找到右
class Add1{
	public static void main(String[] args) {
		A a1=new A();//查詢文件數量 is-a A,is-a School-->方法名 宣告a1 類型A
		System.out.println(a1);//記憶體位址是看後面的A
		a1.skill();//繼承
		a1.skill2();//override
		a1.skillA();//宣告為類型A 從A裡找出skillA

		
		System.out.println("=========================");
		School a2=new A();//查詢文件數量 is-a School-->方法名 宣告a2 類型School
		System.out.println(a2);//記憶體位址是看後面的A
		a2.skill();//繼承
		a2.skill2();//override
		//a2.skillA();宣告為類型School 編譯從School裡找不到skillA"編譯失敗"
		((A)a2).skillA();//利用括號，把a2轉為類型A，從A裡找到skillA



	}
}