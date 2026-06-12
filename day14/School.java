//final + class 使其無法被繼承
/*final*/ class School{
	//field
	//final + field使其無法改變數值

	final double pi=3.14;
	final double pi2=3.2;
	//final double pi2;->final必須給初始值
	//final 可以暫時不給值，之後由建構式給值


	//constructors



	//methods

	//final + methods 使其無法override

	final void show(){
		System.out.println("School show");
	}
	
	void skill(){
		System.out.println("school skill");
	}

	void skill2(){
		System.out.println("school skill2");
	}

	void skillA(){}//讓每個A都有skillA
}