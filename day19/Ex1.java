interface BookStyle1{
	double bookPrice(double price);
	String bookName(String name);
}



class Ex1{
	public static void main(String[] args) {
		BookStyle1 b1=new BookStyle1(){
			public double bookPrice(double price){
				return price*0.95;
			}

			public String bookName(String name){
				return name;
			}
		};
		System.out.println(b1+"\t書名:"+b1.bookName("java11")+"\t價格:"+b1.bookPrice(1000));
	}
}