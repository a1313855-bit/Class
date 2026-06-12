//類別類內外部class
//外部class
class School2{
	void show1(){
		System.out.println("School2 show1");
	}

	static void show2(){
		System.out.println("School2 show2");
	}


//內部class "如果內部類別沒有static 內部類別裡的方法也不能加static"
	static class A{
		void showA1(){
		System.out.println("A showA1");
	}

		static void showA2(){
			System.out.println("A showA2");
		}


	}
}


//以下是獨立的一個.java檔案(因為教學才放一起)
class Ex2{
	public static void main(String[] args){
		//static 不用經過new 所以直接A呼叫
		School2.A a1=new School2.A();
		System.out.println(a1);
		//沒static a1=new School2.A() 呼叫出showA1
		a1.showA1();
		new School2.A().showA1();

		//static 不用經過new School2.A路徑呼叫
		a1.showA2();

		/*
		School2 s=new School2();
		
		//沒static s=new School2() 所以呼叫出show1
		s.show1();
		new School2().show1();

		//static 不用經過new 所以直接School2呼叫
		School2.show2();
		*/
	}
}