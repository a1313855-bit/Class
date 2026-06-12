//類別類內外部class
//外部class
class School1{
	void show1(){
		System.out.println("School1 show1");
	}

	void show2(){
		System.out.println("School1 show2");
	}


//內部class "如果內部類別沒有static 內部類別裡的方法也不能加static"
	class A{
		void showA1(){
		System.out.println("A showA1");
	}

		/*static*/ void showA2(){
			System.out.println("A showA2");
		}


	}
}


//以下是獨立的一個.java檔案(因為教學才放一起)
class Ex1{
	public static void main(String[] args){
		//宣告School1裡的A 變數 = new(新增)School1 裡的 new A (物件)
		School.A a=new School().new A();
		//記憶體位址 School1$A
		System.out.println(a);
		//a 在 School1$A 位址所以找到a.showA
		a.showA();
		//a.show1();->在School1所以找不到

		/*
		例:一個人做show1 , show2
		School s1=new School();
		s1.show1();
		s1.show2();
		
		例:兩個人 做自己的事
		System.out.println(new School());->位址不一樣
		System.out.println(new School());->位址不一樣
		例:一個人做show1 , 一個人做show2
		new School().show1();
		new School().show2();
		new School().show1();
		*/
	}
}