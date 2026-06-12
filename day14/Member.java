class Member{
	//field
	String name;
	final String userName;//final 沒給值的話就要由建構式給

	//constructors
	Member(String name,String userName){
		this.name=name;
		this.userName=userName;
	}
}