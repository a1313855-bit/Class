class Company{
	//field
	private String name;

	//constructors
	Company(String name){
		this.name=name;
	}

	//mathods
	protected String getError(String errorMsg){
		return "Company Error-->"+errorMsg;
	}

	void skill(){
		System.out.println("Company skill");
	}

	void change(String name){
		this.name=name;
	}

	String show(){
		return "名:"+name;
	}
}