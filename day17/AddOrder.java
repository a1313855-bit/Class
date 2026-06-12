import java.util.Scanner;

class AddOrder{
	public static void main(String[] args) throws Check /*throws Exception*/{
		Order[] o=new Order[3];

		o[0]=new Order("o1",1,2);
		o[1]=new Order("o2",2,2);
		o[2]=new Order("o3",2,1);

		for(int i=0;i<o.length;i++){
			o[i].show();
		}

		System.out.println("==========================");

		o[1].setLcd(20);
		for(Order u:o){
			u.show();
		}

		System.out.println("==========================");
		
		Scanner sc=new Scanner(System.in);
		System.out.print("請輸入:");
		int ram=sc.nextInt();
		assert ram>=0:"需>=0";//不符合的條件:"顯示說明"
		//使用時CMD必須打 java -ea 檔名
		o[1].setRam(ram);
		for(Order u:o){
			u.show();
		}


		/*
		Order[] o=new Order[3];
		try{
			o[0]=new Order("o1",-1,2);
			o[1]=new Order("o2",2,2);
			o[2]=new Order("o3",2,1);

			for(Order u:o){
			u.show();
			}

			System.out.println("==========================");

			o[1].setLcd(20);
			for(Order u:o){
				u.show();
			}

		}
		catch(Exception e){
			System.out.println("新增lcd與ram的數量需>=0 b");
			e.printStackTrace();
		}
		*/	

		/*
		Order o1=new Order("abc",1,1);
		o1.show();
		o1.setLcd(3);
		o1.setRam(3);
		o1.show();
		*/
	}
}