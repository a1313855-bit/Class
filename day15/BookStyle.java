//abstract class BookStyle
interface BookStyle{//interface(抽象super)->abstract class
	//field->只限final(常數),預設 public static final 變數 ->可省略
	public static final double pi=3.14;
	double pi2=3.14159;

	//constructors->變抽象不能new (不會有建構式)
	//BookStyle(){}

	//methods->java7以前只限定抽象方法
	//抽象完整寫法-->public abstract 方法 ->public abstract可省略
	public abstract String bookName(String name);
	double bookPrice(double price);


	//java8以後允許一般方法，需搭配default,static
	//完整寫法-->public default , public static ->public 可省略
	
	//物件類,繼承給sub class o->override
	default void show1(){
		System.out.println("hello java default");
	}

	//類別類，沒有繼承給sub class
	static void show2(){
		System.out.println("hello java static");
	}
}