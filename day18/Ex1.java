interface BookStyle1{
	String bookName(String name);
	double bookPrice(double price);
}

class Book1 implements BookStyle1{
	public String bookName(String name){
		return name;
	}

	public double bookPrice(double price){
		return price+10;
	}
}




class Ex1{
	public static void main(String[] args) {
		//BookStyle1 b1=new BookStyle1();->interface 抽象 不能new
		//Book1 b1=new Book1();
		
		//異質宣告
		BookStyle1 b1=new Book1();
		//匿名子類別
		BookStyle1 b2=new BookStyle1(){
			public String bookName(String name){
				return name;
			}
			public double bookPrice(double price){
				return price;
			}
		};
		//測試
		System.out.println(b1.bookPrice(100));
		System.out.println(b2.bookPrice(100));
	}
}