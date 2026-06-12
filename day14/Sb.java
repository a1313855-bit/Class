/*"注意"當繼承的super變抽象
解決方法:
1.sub類別也變抽象
2.把super的抽象方法，帶到自己的方法裡
*/
class Sb extends Student{
	private int eng;

	Sb(String name,int eng){
		super(name);
		this.eng=eng;
	}

	void setChi(int chi){};

}