interface BookStyle3{
	String bookName(String name);
	double bookPrice(double price);
}

class Ex3{
	public static void main(String[] args) {
		System.out.println("價格合計:"+(
			new BookStyle3(){
				public String bookName(String name){
					return null;
				}
				public double bookPrice(double price){
					return price*0.9;
				}
			}.bookPrice(1000)+
			new BookStyle3(){
				public String bookName(String name){
					return null;
				}
				public double bookPrice(double price){
					return price*0.8;
				}
			}.bookPrice(1000)
		));
	}
}