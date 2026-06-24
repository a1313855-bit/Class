package lambdaEx;

interface Book1{
	double pi=3.14;
	
	String book_name(String name) ;
	
	default String show1() {
		return "hello show1";
	}
	
	static String show2() {
		return "hello show2";
	}
}

class BooKStyle1 implements Book1{

	@Override
	public String book_name(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

public class Ex1 {

	public static void main(String[] args) {
		System.out.println(Book1.pi);
		
		//匿名
		Book1 b1=new Book1() {
			@Override
			public String book_name(String name) {
				// TODO Auto-generated method stub
				return "name:"+name;
			}
		};
		
		System.out.println(b1.show1());
		
		//Lambda
		Book1 b2=(name)->"name:"+name;
		
		System.out.println(b2.book_name("teacher"));
	}
}
