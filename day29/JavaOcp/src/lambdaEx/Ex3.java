package lambdaEx;

interface Book3<E,T>{
	//轉型
	T book_price(E price);
}

public class Ex3 {

	public static void main(String[] args) {
		String price="1000";
		Book3<String,Double> b1=(String inPrice)->Double.parseDouble(inPrice)*0.95;
		System.out.println(b1.book_price(price));
		System.out.println(price);
		
		Book3<String,Integer> b2=Calprice::price1;
		Book3<Double,Integer> b3=Calprice::price2;
		Book3<Integer,Double> b4=Calprice::price3;
		
		System.out.println(b2.book_price(price));
		System.out.println(b3.book_price(1000.15));
		System.out.println(b4.book_price(3000));
	}

}

class Calprice{
	public static Integer price1(String price) {
		return Integer.parseInt(price);
	}
	
	public static Integer price2(Double price) {
		double p=price;
		return (int)p;
	}
	
	public static Double price3(Integer price) {
		double p;
		if(price>=2000) {
			p=price*0.9;
		}else if(price>=1500){
			p=price*0.95;
		}else {
			p=price;
		}
		return p;
	}
}
