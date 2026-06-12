class Ex5
{
	public static void main(String[] args)
	{
		int x=10;
		//x=x+1;
		//x+=1;
		//x++;
		++x;
		System.out.println("x="+x);

		int y=10;
		//y=y+1;
		//y-=1;
		//y--;
		--y;
		System.out.println("y="+y);

		System.out.println("==================");//分隔線

		int a=10;
		int b;

		//a++;//這裡是後加
		//++a;//這裡是先加
		//b=a++;//先做b=a;後做a=a+1;
		//得出a=11 b=10
		b=++a;//先做a=a+1;後做b=a;
		//得出a=11 b=11
		System.out.println("a="+a);
		System.out.println("b="+b);

	}
}