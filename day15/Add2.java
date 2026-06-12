class Add2{
	public static void main(String[] args){
		Book1 b1=new Book1();
		
		//default 方法->繼承給sub->Book1 找的到
		b1.show1();
		
		//static 方法->沒有繼承給sub->Book1 找不到
		//b1.show2();
		//只能直接呼叫super
		BookStyle.show2();

	}
}