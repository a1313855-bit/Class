class AddMember{
	public static void main(String[] args) {
		Member m=new Member("abc","ttt");
		System.out.println(m.name+"\t"+m.userName);
		m.name="teacher";
		//m.userName="yyy";->final 數值無法修改
		System.out.println(m.name+"\t"+m.userName);
	}
}