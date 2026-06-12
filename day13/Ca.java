class Ca extends Company{
	//field
	private int lcd;

	//constructors	
	Ca(String name,int lcd){
		super(name);
		//建構式super()
		this.lcd=lcd;
	}

	//mathods
	
	//系統會以名子和引數類型來判斷是overloading or override
	//overloading 類型,引數類型不一樣 名子一樣(引數名稱無所謂),
	/*
	void getError(String msg){

	}
	*/

	//override 類型,引數類型,名子一樣(引數名稱無所謂)
	public String getError(String msg){//封裝等級必須>=super才能override
		return "";
	}

	String show(){
		return super.show()+"\tLcd:"+lcd;
		//可以沿用上一層的show()
		//可是這層也有方法show()，所以super.找super的show()。(方法super.)
	}


	void skill(){//override(置換)把super的方法完全照抄，換成新方法。
		System.out.println("Ca skill");
	}

	/*這樣改也可以不過main程式也必須把方法名稱改掉
	void Caskill(){
		System.out.println("Ca skill");
	}
	*/

	void change(int lcd){
		this.lcd=lcd;
	}
}