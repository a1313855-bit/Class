//這裡也必須變成抽象類別
//一旦類別變成抽象後，此類別將無法實體化(無法new),只剩當super的功能
abstract class Student{
	private String name;

	Student(String name){
		this.name=name;
	}

	//抽象方法 abstract
	//除了方法以外 class也必須加上abstract
	abstract void setChi(int chi);

	void setName(String name){
		this.name=name;
	}

	String show(){
		return "名:"+name;
	}
}