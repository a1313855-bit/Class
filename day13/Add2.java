class Add2{
	public static void main(String[] args) {
		A a=new A();//is-a A,is-a School

		//異質宣告 左右兩邊必須有繼承 Ex:super = sub
		School a2=new A();//is-a School

		//記憶體位置同樣都是A
		System.out.println(a);
		System.out.println(a2);


	}
}