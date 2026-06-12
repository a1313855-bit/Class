interface BookStyle2{
	String bookName(String name);
	double bookPrice(double price);
}

class Ex2{
	public static void main(String[] args) {
		BookSytle2 b1=new BookSytle2(){
			public String bookName(String name){
				return name;
			}

			public double bookPrice(double price){
				return price*0.9;
			}
		};

		BookStyle2 b2=new BookStyle2(){
			public String bookName(String name){
				return "book:"+name;
			}
			public double bookPrice(double price){
				return price*0.8;
			}
		};

		System.out.println(b1+"\t書名:"+b1.bookName("java11")+"\t價格:"+b1.bookPrice(1000));
		System.out.println(b2+"\t書名:"+b2.bookName("java8")+"\t價格:"+b2.bookPrice(1000));
		System.out.println("價格合計:"+(b1.bookPrice(1000)+b2.bookPrice(1000)));
	}
}