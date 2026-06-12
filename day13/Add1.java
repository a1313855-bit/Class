class Add1{
	public static void main(String[] args){
		Ca c=new Ca("abc",10);
		System.out.println(c.getError("123"));
		System.out.println("=========================");

		Cb c1=new Cb("def",20);
		System.out.println(c1.show());

		/*
		Ca c1=new Ca("abc",10);//is-a Ca,is-a Company
		
		System.out.println(c1.name+"\t"+c1.show()+"\t"+c1.lcd);
		//has-a name,has-a show,has-a lcd
		c1.lcd=-10;
		c1.name="ttt";
		System.out.println(c1.name+"\t"+c1.show()+"\t"+c1.lcd);
		
		System.out.println(c1.show());
		c1.change("uu");
		System.out.println(c1.show());
		System.out.println("==============================");

		c1.skill();
		//c1.Caskill();
		System.out.println(c1.getError("編譯失敗"));
		*/
	}
}