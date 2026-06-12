class Ex2
{
	public static void main(String[] arge){
		//primitive type
		double d1=10.12;
		double d2=10.12;
		System.out.println("d1="+d1);
		System.out.println("d2="+d2);
		System.out.println(d1==d2);//值==值

		System.out.println("========================");

		//wrapper Class4.0/5.0
		java.lang.Double D1=new java.lang.Double(10.12);//Boxing
		Double D2=10.12;//AutoBoxing
		System.out.println("D1="+D1);
		System.out.println("D2="+D2);
		System.out.println(D1==D2);//物件==物件-->位置==位置

		System.out.println(D1.equals(D2));//若要讓左右相等使用equals
	}
}