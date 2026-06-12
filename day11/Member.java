class Member
{
	//field
	private String name;
	private String address;

	//constructors
	Member(String name,String address){
		this.name=name;
		this.address=address;

	}
	//methods
	String show()
	{
		return "名:"+name+"\t地址:"+address;
	}
}