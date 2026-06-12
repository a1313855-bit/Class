class Cb extends Company{
	//field
	private int ram;

	//constructors
	Cb(String name,int ram){
		super(name);
		this.ram=ram;
	}

	//mathods
	String show(){
		return "Ram:"+ram+"\t"+super.show();
	}
}