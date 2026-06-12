class A extends School1 implements School2,School3,School4{
	//School2->interface 普通方法強制要繼承下來
	public void show2(){
//School2 和 School6 都有show2方法，兩個都override下來不過只會執行一次
//因為School2 和 School6 都是抽象方法，所以他們寫的方法都只代表名子而已。

	}

	public void show3(){

	}

	public void show4(){

	}

	public void show4(){

	}
}