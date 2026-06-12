class Book2 implements BookStyle{
	public String bookName(String name){
		return "書名:"+name;
	}

	public double bookPrice(double price){
		return price*0.95;
	}

	/*
	public void show1(){
		System.out.println("hello java");
	}
	*/
}