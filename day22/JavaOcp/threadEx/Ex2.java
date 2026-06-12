package threadEx;

public class Ex2 {

	public static void main(String[] args) {
		Student2 s1 = new Student2("a1");
		Student2 s2 = new Student2("a2");
		Student2 s3 = new Student2("a3");
		Student2 s4 = new Student2("a4");
		
		Thread t1=new Thread(s1);
		Thread t2=new Thread(s2);
		Thread t3=new Thread(s3);
		Thread t4=new Thread(s4);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		
		/*
		s1.start();
		s2.start();
		s3.start();
		s4.start();
		*/
	}

}
