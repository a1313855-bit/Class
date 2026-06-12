//Lambda 使用條件
//1.必須是interface
//2.只能有一個抽象方法
interface BookStyle4{
	String book(String name,double price);
	//因為是抽象必須sub類別必須override
	//void show();
}

class Ex4{
	public static void main(String[] args) {
		//匿名
		BookStyle4 b1=new BookStyle4(){
			public String book(String name,double price){
				return "書名:"+name+"\t價格:"+price;
			}
			/*override super的方法
			public void show(){
				return show;
			}
			*/
		};

		System.out.println(b1.book("java11",1000));
		System.out.println("=========================");
		//Lambda
		//Lambda只能寫一個方法 另一個寫不出來
		//->Lambda只能使用在 只有一個抽象方法的interface
		BookStyle4 b2=(String name,double price)->"java 書名:"+name+"\t價格:"+price*0.9;
		System.out.println(b2.book("java11",1000));
		System.out.println("=========================");
		//Lambda 簡化寫法
		BookStyle4 b3=(name,price)->"java練習 書名:"+name+"\t價格:"+price*0.8;
		System.out.println(b3.book("java11",1000));
		System.out.println("=========================");
		//Lambda 多行寫法 加上{步驟}
		BookStyle4 b4=(name,price)->{
			String show=null;
			if(price>=2000){
				show="java 書名:"+name+"\t價格:"+price*0.9;
			}else if(price>=1500){
				show="java 書名:"+name+"\t價格:"+price*0.95;
			}else{
				show="java 書名:"+name+"\t價格:"+price;
			}
			return show;
		};
		System.out.println(b4.book("java 10",2000));
		System.out.println(b4.book("java 9",1500));
		System.out.println(b4.book("java 8",1000));
	}
}