class Ex1
//Loop迴圈
//(一)條件
//-->重複且連續步驟

//(二)for-loop
/*
語法:
for(1;2;3)
{
	步驟
}
1.宣告計算次數的變數
2.判斷停止或繼續做
-->boolean條件 true->做 false->不做
3.如何停止的計算是與2.有關
*/
{	
	public static void main(String[] arge){
		for(int i=1;i<=5;++i)
		//i++得出的答案也相同，因為他們的區別在於另一個變數而不是i
		{
			System.out.println("i="+i+"\thello java");
		}
	}
}
/*補充:
	for(int x=1,y=1;x<=50000 || y<=70000;)
		{
			System.out.println("x="+x+"\ty="+y);
			x=2*y+100;
			y=2*x-10;
		}

//條件判斷也可以有多個變數。