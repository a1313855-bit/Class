//generics 泛型 <>
//可以多個泛型
class Order2<E,T>{
	String name;
	E price;
	T amount;

	Order2(String name,E price,T amount){
		}
}

class Ex2{
	public static void main(String[] args) {
		Order2<Integer,Double> o1=new Order2<>("abc",10,10.12);
	}
}