class AddStudent{
	public static void main(String[] args){
		Student s=new Sa("a",80);
		System.out.println(s.show());
		s.setName("abc");
		//((Sa)s).setChi(90);->轉型
		s.setChi(90);
		System.out.println(s.show());

		//Student s1=new Student("qwe");
	}
}