package threadEx;

public class Bus extends Thread{
	private static int sum;
	
	public synchronized static void addPay(int pay) {
		int temp=sum;
		System.out.println("目前總金額:"+temp);
		System.out.println("新進一筆:"+pay);
		temp=temp+pay;
		System.out.println("最新總金額:"+temp);
		sum=temp;
		System.out.println();
	}
	
	public void run() {
		for(int i=1;i<=20;i++) {
			try {
				Thread.sleep(200);
				addPay(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
