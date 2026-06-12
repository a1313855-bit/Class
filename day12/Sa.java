class Sa extends Company
{
	//field
	int lcd;
	int ram;

	//constructors
	Sa(String name,int lcd)
	{			
		//{繼承了Company的建構式可以看成這邊有一串
		/*
		Company(String name){
		this.name=name;
		System.out.println("新增一名員工,名:"+name);
		*/
		super(name);
		//super("abc","taipei");//建構式只能挑一個使用
		/*
		可以看成用super代替了建構式Company的位置
		()內是String name的內容
		*/
		this.lcd=lcd;
		System.out.println("Sa部門,lcd:"+lcd);
	}
	Sa(String name,String address,int lcd)
	{
		super(name,address);
		this.lcd=lcd;
		System.out.println("Sa部門,lcd:"+lcd);
	}
	Sa(String name,String address,int lcd,int ram)
	{
		super(name,address);
		this.lcd=lcd;
		this.ram=ram;
		System.out.println("Sa部門,lcd:"+lcd);
	}
}