//多型宣告
class Add2{
	public static void main(String[] args) {
		School[][] s=new School[3][];
		s[0]=new School[3];
		s[1]=new School[4];
		s[2]=new School[5];
		//is-a School
		s[0][0]=new A();
		s[0][1]=new A();
		s[0][2]=new A();

		s[1][0]=new B();
		s[1][1]=new B();
		s[1][2]=new B();
		s[1][3]=new B();

		s[2][0]=new C();
		s[2][1]=new C();
		s[2][2]=new C();
		s[2][3]=new C();
		s[2][4]=new C();

		System.out.println(s);//記憶體位址School[][]
		for(int i=0;i<s.length;i++){
			System.out.println("\t"+s[i]);//記憶體位址School[]
			for(int j=0;j<s[i].length;j++){
				System.out.println("\t\t"+s[i][j]);//記憶體位址School
			}
		}

		System.out.println("===================================");
		//for-each
		System.out.println(s);//記憶體位址School[][]
		for(School[] o:s){
			System.out.println("\t"+o);//記憶體位址School[]
			for(School u:o){
				System.out.println("\t\t"+u);//記憶體位址School
			}
		}

		System.out.println("===================================");
		//School->skill
		s[0][0].skill();
		s[1][0].skill();
		s[2][0].skill();
		System.out.println("===================================");
		//School->skill2
		s[0][0].skill2();//A->skill(override)
		s[1][0].skill2();//(繼承)
		s[2][0].skill2();//(繼承)
		System.out.println("===================================");
		//School->skillA
		//s[0][0].skillA();編譯s->School從School開始找，沒有skillA"編譯失敗"
		((A)s[0][0]).skillA();//用括號School轉成類型A
		//遇到多個都要改，且有super原始碼的情況，可以在super裡加上skillA(){}
		//執行從A開始找，所以變成override
		s[0][1].skillA();
		s[0][2].skillA();
		System.out.println("===================================");
		//java.lang.Object 以下是所有class的共同super
		//equals用途 檢測內容是否相同

		s[0][0].skill2();
		s[1][0].skill2();
		System.out.println(s[0][0]+","+s[1][0]);
		System.out.println(s[0][0].equals(s[1][0]));//檢測是否為相同 false

		System.out.println("");		
		
		s[0][0]=s[1][0];//還是位址，不是資料 位址=位址
		s[0][0].skill2();
		s[1][0].skill2();
		System.out.println(s[0][0]+","+s[1][0]);
		System.out.println(s[0][0].equals(s[1][0]));//檢測是否為相同 true

		System.out.println("===================================");
		//getClass用途 找尋該物件所在class
		System.out.println(s[2][0].getClass());//Class C
		//前面不想顯示class,後面加上getName
		System.out.println(s[2][0].getClass().getName());//C

		System.out.println("===================================");
		//toString用途 顯示記憶體位址
		System.out.println(s[2][0]);//這個也會顯示記憶體位址
		System.out.println(s[2][0].toString());
		System.out.println("===================================");
		//instanceof用途 檢測是否為內容是否為此class
		System.out.println(s[2][2] instanceof C);//true
		System.out.println(s[2][2] instanceof B);//false
		System.out.println(s[2][2] instanceof School);//true


	}
}