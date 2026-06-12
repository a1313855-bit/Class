//自訂Exception class
class Check extends Exception{
	Check(String error_msg){
		String show=error_msg+"使用者輸入的皆須>=0"+
		"\n不可輸入小數";
		System.out.println(show);
	}

	Check(String error_msg,boolean member){
		String show=error_msg+"使用者輸入的皆須>=0"+
		"\n不可輸入小數";

		System.out.println(show+"\t是否是會員:"+member);
	}
}