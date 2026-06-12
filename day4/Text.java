class Text
/*
1.請選擇合法的敘述句。(選擇2個)
  A. String #s1="Hi!";
  B. int $money=1000;
  C. double _tax=0.06;
  D. double ~pi=3.14;
  //變數名稱，符號只能使用 $ _

2.程式碼如下:
	
	 int i=1;
	 long I=1;
	 float f=1.0f;
	 double d=1.0;
	 sum=i+I+f+d;

請問sum應該定義成什麼資料類型?
A. byte
B. short
C. int
D. long
E. float
F. double
	double>float>long>int>short>byte

3.下列選向哪些可以編譯成功?(選擇3個)
  A. int i=(int)(1+1.1f+1.1);
  B. double d=(float)(1+1.1f+1.1);
  C. long I=1+1.1f+1.1;
  D. float f=(long)(1+1.1f+1.1);
  E. int i=(int)1.1f+1.1;
  //資料類型左右要相同若不同也必須左大=右小

4. 7+6-5*4/3%(2+1)的結果為何?

    A. 13
    B. 14
    C. 15
    D. 16
    E. 17

5.程式碼如下，請問最後結果為何?

     int i=100;
     String s="10";
     s+=i;
     System.out.println(s);

  A. 110
  B. 10010
  C. 10100
  D. 11000
  E. 編譯失敗

6.程式碼如下，請問最後結果為何?

      boolean result;
      int i=1;
      result=1==2 && ++i>=2;
     	//&&只要遇到false，就會直接中止。
     	//&就算遇到false，也會把剩下的算是做完。
      System.out.println("result="+result+",i="+i);

   A. result=true , i=1
   B. result=true , i=2
   C. result=false , i=1
   D. result=false , i=2
   E. 編譯失敗

7. 程式碼如下，請問最後結果為何?
    
       int x=1, y=1;
       boolean b=++x>++y;
		//x=x+1;y=y+1;x(2)>y(2);false x=2,y=2
       System.out.println(b);

   A. true
   B. false
   C. 編譯失敗

   		//boolean b=++x>y++;
		//x=x+1;x(2)>y(1);y=y+1;true x=2,y=2

8.程式碼如下，請問最後結果如何?
     
       int x=1 , y=1;
       boolean b=!(x>y)^!(x<y);
       System.out.println(b);

    A. true
    B. false
    C. 編譯失敗

9.程式碼如下,請問最後結果如何?
	 class Test{
	     public static void main(String args[]){
	        int x=2;
	 	   int y=1;
	        if((x==1)&&(y == 2))
	            System.out.print("x=1,");
	            System.out.print("y=2, ");
	        if((x+y)==3)
	            System.out.print("x+y=3");
	        }
	  }
  
  A. x=1 , y=2 , x+y=3
  B. y=2 , x+y=3
  C. x=1 , y=2
  D. x+y=3
  E. 編譯失敗
  //if可以不使用{}，不使用{}的話只會影響下面的一行，答案是:B

10.程式碼如下，請問最後結果為何?
	 int x=0;
	 int y=0;
	 do{
	 y++;
	 ++x;
	 }while(x<5);
	 System.out.println(x+","+y);

 A. 5,6
 B. 5,5
 C. 6,5
 D. 6,6
 E. 編譯失敗


11.程式碼如下，請問最後結果為何?
	 
	 {
	 public static void main(String args[]){
	 String str;
	 z://laber必須寫在for上面
	 str="";
	 for(int x=3;x<8;x++){
	    if(x==4) break;
	    if(x==6) break z;
	    str+=x;
	    }
	    System.out.println(str);
	   }
	 }

 A. 3
 B. 34
 C. 345
 D. 3456
 E. 34567
 F. 編譯失敗


12.程式碼如下，請問最後果為何?
	 
	 {
	 public static void main(String args[]){
	    int i=2000;
        int j=1999;
	    int k=1000;
       	if((i>j)^((k*2)==i))
	    	System.out.println(1);
	    if((j+1)!=i^((k*2)==j))
	    	System.out.println(2);
	    }
	 }

 A. 1
 B. 2
 C. 12
 D. 沒有任何輸出
 E. 執行失敗
 F. 編譯失敗


13.程式碼如下，請問最後結果為何?
	 */
	 {
	 public static void main(String args[]){
	     String str="";
	     z:
	     for(int x=0;x<3;x++){
	         for(int y=0;y<2;y++){
	             if(x==1) break;
	             if(x==2) break z;
	             str=str+x+y;
	          }
	      }
	      System.out.println(str);
	     }
	 }
/*
 A. 00
 B. 0001
 C. 000110
 D. 00011011
 E. 編譯失敗

 解:
 x=0、1、2  y=0、1
 ->str=str+x+y
 1.x=0,y=0->str=""+0+0=00
   x=0,y=1->str=00+0+1=0001
 
 2.x=1,y=0->str=0001+1+0=000110
   x=1,y=1->str=000110+1+1=00011011
 
 3.x=2,y=0->str=00011011+2+0=0001101120
   x=2,y=1->str=0001101120+2+1=000110112021    

 */