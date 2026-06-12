class Student//class->表-->參照管理的表名字
//這裡的class->定義、規則
{
	//field欄位--?資料表的欄位+datatype
	//若有初始值，則直接套用
	String sname;
	int chi;
	double eng;
	boolean x;
	//String預設值null(空值)
	//int預設值0
	//double預設值0.0
	//boolean預設值false

	

	//constructor建構式
	/*
	1.建構式名稱必須跟class名稱相同
	2.建構式名稱前面不可以加任何東西
	3.如有建構式則強制執行。
	*/
	 Student(String sname,int chi,double eng)//local->參數引數
	 {
	 	this.sname=sname;
	 	this.chi=chi;//this->暫時的物件名稱
	 	this.eng=eng;

	 	//int chi=60;//local區域變數
	 	//在此括號內找到宣告所以套用。
	 	
	 	//chi=60;//Global全域變數
	 	//因為在此括號內無宣告指令，所以往上一個大括號找。

	 	//System.out.println("新增一位學生");
	 }

	//methods方法

	void show()
	{
		System.out.println("名稱:"+sname+"\t國文:"+chi+"\t英文:"+eng);//Global全域變數
	}
}