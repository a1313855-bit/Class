enum Book{
	java11(600,10),//Book java11=new Book(600,10);
	javaWeb(650,5),//Book javaWeb=new Book();
	Spring(700,7);//Book Spring=new Book();
	//後面的括號，建構式的引數區

	private int price;
	private int amount;

	private Book(int price,int amount){
		this.price=price;
		this.amount=amount;
	}

	public int getPrice(){
		return price;
	}

	public int getAmount(){
		return amount;
	} 
}
/*
java 7.0以後-->物件儲存
Book[]
enum裡的建構式不開放使用，只能給自己用所以private

*/


class Ex6{
	public static void main(String[] args) {
		Book[] book=Book.values();
		for(int i=0;i<book.length;i++){
			System.out.println(book[i]+
				"\t"+book[i].getPrice()+
				"\t"+book[i].getAmount());
		}
	}
}