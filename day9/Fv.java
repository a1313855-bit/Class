class Fv
{
	//field
	private double fv;
	private double r;
	private static int pv;
	private int n;

	//consfructors
	Fv(int pv,double r,int n)
	{
		this.pv=pv;
		this.r=r;
		this.n=n;

		fv=pv*(1+r*n);
	}

	//mathods
	
	static void setPv(int pv)
	{
		if(pv>=0)
		{
			Fv.pv=pv;//this-->物件名f1,f2 static是類別類-->要呼叫的會是物件名稱
		}
	}

	/*static*/ void setR(double r)//這裡面的變數有field區的變數不能加static
	{
		if(r>=0)
		{
			this.r=r;
		}
	}
	
	static int cal(int a,int b)
	{
		return a*b;
	}

	static String companyName()
	{
		return "巨匠電腦";
	}

	void show()
	{
		fv=pv*(1+r*n);

		System.out.println("本金:"+pv+
			"\t年利率:"+r+
			"\t期數:"+n+
			"\t單利本利和:"+fv);
	}
}