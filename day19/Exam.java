class Order{
	public void show(){
		System.out.println("Order test");
	}
}

class Exam{
	public static void main(String[] args) {
		//只有o1 override
		Order o1=new Order(){
			public void show(){
				System.out.println("o1 Order test");
				//利用show方法呼叫o1內部類別的abc方法
				abc();
			}
			//可以新增新的方法
			public void abc(){
				System.out.println("o1 abc test");
			}
		};
		o1.show();
		//不能直接呼叫匿名內部類別方法，需透過方法呼叫方法
		//o1.abc();
		System.out.println("=========================");

		//o2不 override
		Order o2=new Order();
		o2.show();
	}
}