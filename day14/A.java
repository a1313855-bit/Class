class A extends School{

	void showA(){//School 因show+final無法override所以只能修改名稱
		System.out.println("A show");
	}

	void skill2(){
		System.out.println("A skill2");
	}

	void skillA(){
		System.out.println("A skillA");
	}
}