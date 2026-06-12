package threadEx;

public class Ex1 {

	public static void main(String[] args) throws InterruptedException {
		Student s1 = new Student("a1");
		Student s2 = new Student("a2");
		Student s3 = new Student("a3");
		Student s4 = new Student("a4");
		s1.start();
		s2.start();
		s2.join();
		s3.start();
		s4.start();

		/*
		 * for (int i = 1; i <= 10; i++) { try { Thread.sleep(150);
		 * System.out.println("hello java"); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 * 
		 * }
		 */
	}

}
