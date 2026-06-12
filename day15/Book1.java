class Book1 implements BookStyle{
//super是interface x->extends o->implements
//super是抽象所以解決方法兩種
/*
1.sub自己變成抽象->abstract class Book1 implements BookStyle
2.方法全部都繼承下來override
*/

//override 要記得權限要一樣 或 更大
//super是抽象，所以方法全部都是public，public 權限已經是最高
//->public 方法
	public double bookPrice(double price){
		return price;
	}
	
	public String bookName(String name){
		return name;
	}

	/*
	public void show1(){
		System.out.println("hello java");
	}
	*/
}