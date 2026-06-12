//可以想像成 "文字" 一維陣列
enum Subject{
	word,excel,power;
}
/*
static final Subject ?={"word","excel","powerpoint"}


*/

class Ex4{
	public static void main(String[] args){
		//可以直接打名字呼叫
		System.out.println(Subject.word);
		//宣告整組，利用方法 .values 生成物件
		Subject[] s=Subject.values();
		System.out.println(s[0]);

		for(int i=0;i<s.length;i++){
			System.out.print(s[i]+" ");
		}
	}
}