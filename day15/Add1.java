class Add1{
	public static void main(String[] args){
		//BookStyle b1=new BookStyle();->變抽象不能new
		//因為是static直接呼叫
		System.out.println(BookStyle.pi);
		System.out.println(BookStyle.pi2);
		//BookStyle.pi=2.01;->final(常數) 不能修改值

		Book1 b1=new Book1();
		Book2 b2=new Book2();
		System.out.println("============================");

		System.out.println(b1.bookName("java11")+"\t"+b1.bookPrice(1000));
		System.out.println(b2.bookName("java11")+"\t"+b2.bookPrice(1000));

		System.out.println("============================");

		BookStyle[][] b=new BookStyle[][]
		{
			{
				new Book1(),
				new Book1(),
				new Book1()
			},
			{
				new Book2(),
				new Book2()
			}
		};

		System.out.println("============================");

		System.out.println(b);
		for(int i=0;i<b.length;i++){
			System.out.println("\t"+b[i]);
			for(int j=0;j<b[i].length;j++){
				System.out.println("\t\t"+b[i][j]+
					"\t"+b[i][j].bookName("java11")+
					"\t"+"價格:"+b[i][j].bookPrice(1000));
			}
		}

		System.out.println("============================");
		//for-each
		System.out.println(b);
		for(BookStyle[] o:b){
			System.out.println("\t"+o);
			for(BookStyle u:o){
				System.out.println("\t\t"+u+
					"\t"+u.bookName("java11")+
					"\t"+"價格:"+u.bookPrice(1000));
			}
		}


	}
}