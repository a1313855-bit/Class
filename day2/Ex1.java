class Ex1
{
	public static void main(String[] args)
	{
		System.out.println("10+20");
		//加上雙點號中間為文字
		System.out.println(10+20);
		//數字的直接運算
		System.out.println("10"+"20");
		//這邊的+為合併
		System.out.println("10"+20);
		//若文字加上數字，以文字為主
		System.out.println(10+10+10);
		//可以做連續加法
		System.out.println("10+20="+10+20);
		//語言和數學運算相同，會由左至右運算
		System.out.println("10+20="+(10+20));
		/*
		若想要令"10+20"結果等於30
		需要先把結果10+20用()先行運算
		*/
	}
}