class Ex6
{
	public static void main(String[] args) 
	{
		java.util.Scanner sc=new java.util.Scanner(System.in);
		System.out.println("請輸入會員等級:"+
	                       "\n1)VIP"+
	                       "\n2)金卡"+
	                       "\n3)銀卡"+
	                       "\n4)普通會員");
	                       //若文字太長，可利用"文字"+換行"文字"的方法來整理
						   //注意:這裡的換行並不會使CMD內容換行，想換行要加上\n
		
		//int member=sc.nextInt();//整數
		
		//char member='D';//char

		String member=sc.next();//String

		switch(member)//後 必須是變數(1.整數 2.char 3.String)
		{
			//case 1://整數
			//case 'A'://char
			case "Level_1":
				System.out.println("VIP");
				break;//如果沒有輸入break流程會繼續往下跑
			//case 2://整數
			//case 'B'://char
			case "Level_2"://String
				System.out.println("金卡");
				break;
			//case 3://整數
			//case 'C'://char
			case "Level_3"://String
				System.out.println("銀卡");
				break;
			//case 4://整數
			//case 'D'://char
			case "Level_4"://String
				System.out.println("普通會員");
				break;
			default:
				System.out.println("\n重新輸入"+
					               "\nLevel_1 、 Level_2 、 Level_3 、 Level_4"+
					               "其中一個選項");							
		}
	}
}