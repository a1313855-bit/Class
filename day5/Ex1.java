class Ex1
{
	public static void main(String[] args) {
		Student s=new Student("abc",60,10.5);//後面的Student()->建構式
		s.show();

		/*
		Student s1=new Student();//宣告參照資料
		Student s2=new Student();
		
		s1.show();
		s2.show();
		*/

		/*
		System.out.println(s1);
		System.out.println(s1.sname);
		System.out.println(s1.chi);
		System.out.println(s1.eng);
		System.out.println(s1.x);
		System.out.println(s2);
		System.out.println(s2.sname);
		System.out.println(s2.chi);
		System.out.println(s2.eng);
		System.out.println(s2.x);
		*/

		/*
		int x=10;
		//如果只宣告變數，並未給值，並不消耗記憶體容量(RAM)，也可以說是不存在。

		System.out.println(x);
		*/

		//非物件導向
		/*
		String name1="rrr";
		int chi1=75;
		int eng1=55;
		int math1=74;

		String name2="auu";
		int chi2=85;
		int eng2=65;
		int math2=74;

		System.out.println("名:"+name1+"\t國文:"+chi1+"\t英文:"+eng1);
		System.out.println("名:"+name2+"\t國文:"+chi2+"\t英文:"+eng2);
		*/
	}
}