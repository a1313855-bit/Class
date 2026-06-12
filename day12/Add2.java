class Add2
{
	public static void main(String[] args){
		//Company x=new Company("abc");
		//default建構式:如果class內沒有手動設計建構式 java會幫你自動產生一個建構式

		/*
		Sa繼承Company的建構式(建構式是強制執行)
		SuperClass建構式先執行，後執行SubClass
		*/
		Sa x=new Sa("abc",10);//is-a Sa,is-a Company
		//Sa_1 x=new Sa_1();//is-a Sa_1,is-a Sa,is-a Company
		
	}
}