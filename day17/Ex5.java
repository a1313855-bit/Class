class Company{
	enum Week{
		星期一,星期二,星期三;
	}

	enum Month{
		一月,二月,三月;
	}
}



class Ex5{
	public static void main(String[] args){
		Company.Week[] w=Company.Week.values();
		Company.Month[] m=Company.Month.values();

		for(int i=0;i<w.length;i++){
			System.out.println(w[i]+"\t"+m[i]);

		}
	}
}