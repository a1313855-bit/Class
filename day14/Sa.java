class Sa extends Student{
	private int chi;

	Sa(String name,int chi){
		super(name);
		this.chi=chi;
	}

	void setChi(int chi){
		this.chi=chi;
	}

	String show(){
		return super.show()+"\t國文:"+chi;
	}
}