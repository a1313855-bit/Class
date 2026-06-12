//generics 泛型 <>
class Order<E>{
	String name;
	//不鎖死 product 的類型
	E product;

	Order(String name,E product){
		this.name=name;
		this.product=product;
	}
}

/*要求:
product 要可以輸入int , double
可是 輸入int 時不可以有小數點
*/
class Ex1{
	public static void main(String[] args){
		//<Datatype> 此類型必須是class類別
		//Double(包覆類別) 跟 double(基本類別) 是不同的
		//Double 強制要求輸入的資料必須符合浮點數
		//double 可以輸入整數Ex:10 -> 10.0
		Order<Double> o1=new Order<Double>("abc",10.12);
		System.out.println(o1.name+"\t"+o1.product);

		Order<Integer> o2=new Order<Integer>("abc",100);
		System.out.println(o2.name+"\t"+o2.product);

		//宣告的<>必須寫東西 後面的<>可以省略不寫
		Order<Integer> o3=new Order<>("abc",200);
		System.out.println(o3.name+"\t"+o3.product);
	}
}