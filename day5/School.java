class School
{
	//field
	String name;
	int chi;
	int eng;
	int sum;

	//constructors
	School(String name,int chi,int eng)
	{
		this.name=name;
		this.chi=chi;
		this.eng=eng;
		this.sum=this.chi+this.eng;
	}

	//methods
	void show()
	{
		System.out.println("名稱:"+name+"\t國文:"+chi+"\t英文:"+eng+"\t總分:"+sum);
	}
}