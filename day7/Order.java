/*設計-購物系統
(一)產品資料
品名:
lcd->4999 
ram->1280
mouse->750
(二)資料庫->表Order
name->String
lcd->int
ram->int
mouse->int
sum->double
member->int
(三)功能需求
1.輸入(新增)
1)判斷->led,rem,mouse>=0
2)輸入name,led,rem,mouse,member
3)計算折扣->sum>=20000 打95折
         ->是會員打95折(可疊加)
2.輸出
你的購物細目
名:
lcd:
rem:
mouse:
會員:
金額:
*/
class Order
{
	//field
	private String name;
	private int lcd;
	private int ram;
	private int mouse;
	private int member;
	private double sum;

	//constructors
	 Order(String name,int lcd,int ram,int mouse,int member)
	{
		if(lcd>=0&&ram>=0&&mouse>=0)
		{
			this.name=name;
			this.lcd=lcd;
			this.ram=ram;
			this.mouse=mouse;
			this.member=member;
			sum=lcd*4999+ram*1280+mouse*750;
			if(sum>=20000) sum=sum*0.95;
			if(member==1) sum=sum*0.95;
		}
	}


	//methods
	String getName()//讀取
	{
		return name;
	}
	void setName(String name)//修改
	{
		this.name=name;
	}

	int getLcd()//讀取
	{
		return lcd;
	}
	void setLcd(int lcd)//修改
	{
		if(lcd>=0)//數量不能是負數加上條件
		{
			this.lcd=lcd;//數量改變重新計算
			sum=lcd*4999+ram*1280+mouse*750;
			if(sum>=20000) sum=sum*0.95;
			if(member==1) sum=sum*0.95;
		}		
	}

	int getRam()//讀取
	{
		return ram;
	}
	void setRam(int ram)//修改
	{
		if(ram>=0)
		{
			this.ram=ram;
			sum=lcd*4999+ram*1280+mouse*750;
			if(sum>=20000) sum=sum*0.95;
			if(member==1) sum=sum*0.95;
		}
	}
	
	int getMouse()//讀取
	{
		return mouse;
	}
	void setMouse(int mouse)//修改
	{
		if(mouse>=0)
		{
			this.mouse=moouse;
			sum=lcd*4999+ram*1280+mouse*750;
			if(sum>=20000) sum=sum*0.95;
			if(member==1) sum=sum*0.95;
		}
	}


	void changeOrder1(int lcd,int ram,int mouse)
	{
			this.lcd=lcd;
			this.ram=ram;
			this.mouse=mouse;
			sum=lcd*4999+ram*1280+mouse*750;
			if(sum>=20000) sum=sum*0.95;
			if(member==1) sum=sum*0.95;
	}

	double changeOrder2(int lcd,int ram,int mouse)
	{
			this.lcd=lcd;
			this.ram=ram;
			this.mouse=mouse;
			sum=lcd*4999+ram*1280+mouse*750;
			if(sum>=20000) sum=sum*0.95;
			if(member==1) sum=sum*0.95;
			return sum;
	}

	void show()
	{
		System.out.println(
			name+"你的購物清單:"+
			"\nlcd:"+lcd+
			"\nram:"+ram+
			"\nmouse:"+mouse+
			"\n會員:"+member+
			"\n金額:"+sum);
	}
}