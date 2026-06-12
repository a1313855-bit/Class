//import java.util.Scanner;
class AddFv
{
	public static void main(String[] arge){
		//Fv.pv=40000;//static類別類
		//f1.r=0.0123//物件類(必須先經過new)

		System.out.println(Fv.cal(10,20));
		System.out.println(Fv.companyName());//加上static可以在new之前出現

		Fv f1=new Fv(50000,0.012,4);
		Fv f2=new Fv(50000,0.013,3);
		Fv f3=new Fv(50000,0.014,2);
		Fv f4=new Fv(50000,0.015,1);
		
		f1.show();
		f2.show();
		f3.show();
		f4.show();

		System.out.println("=============================");
		
		//Fv.pv=100000;
		Fv.setPv(100000);
		//f1.r=0.0123;
		f1.setR(0.011);

		System.out.println(f2.companyName());
		System.out.println(Fv.cal(10,20));
		
		f1.show();
		f2.show();
		f3.show();
		f4.show();

		
		/*自我練習:
		Scanner sc=new Scanner(System.in);
		System.out.print("請輸入本金:");
		int pv=sc.nextInt();
		System.out.print("請輸入利率:");
		double r=sc.nextDouble();
		System.out.print("請輸入期數:");
		int n=sc.nextInt();
		Fv f=new Fv(pv,r,n);
		*/
	}
}