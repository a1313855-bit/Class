class Ex2
//(三)while-loop
/*
語法:
1.
while(boolean條件)
{
	步驟
}
*/
{
	public static void main(String[] arge){
		int i=1;
		while(i<=5)
		{
			System.out.println("i="+i+"\thello java");
			i++;
		}

/*		
2.do
{
	步驟
}while(boolean條件)
*/

		int x=1;
		do
		{
			if(x<=5)
			{
				System.out.println("x="+x+"\thello java");
				x++;
			}
			else
			{
				System.out.println("error,x="+x);
			}
		}while(x<=5);
	}
}

/*
1跟2的區別在於，當變數不符合條件時，
情況1由於while先判斷後不符合條件所以程式會直接不執行。
情況2while是後面才判斷，所以程式會先執行一次錯誤的結果，後面才會停止
//情況2可以使用在監控、伺服器之類的地方，可以監測到錯誤的地方。
*/

