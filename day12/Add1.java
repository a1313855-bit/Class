class Add1
{
	public static void main(String[] args) {
		A a1=new A();
		/*
		A is-a A
		A has-a word
		A has-a show()

		A is-a Student
		A has-a name
		A has-a chi
		*/
		System.out.println(a.word);
		a1.show();
		System.out.pritnln(a1.name);
		System.out.println(a1.chi);

		B b1=new B();

		a1.show();
		b1.show();
	}
}