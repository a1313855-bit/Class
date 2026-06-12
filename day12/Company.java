class Company
{
	//field
	String name;
	String address;

	//constructors
	//default建構式:若沒有手動設計建構式 java會幫你自動產生一個建構式
	//Company(){}
	//若有subClass，強制執行建構式時，則必須手動增加Company(){}
	Company(String name){
		this.name=name;
		System.out.println("新增一名員工,名:"+name);	
	}

	Company(String name,String address){
		this.name=name;
		this.address=address;
		System.out.println("新增一名員工,名:"+name+"\t地址:"+address);
	}
}