package threadEx;

public class Student2 extends School implements Runnable{
	private String name;

	public Student2(String name) {
		super();
		this.name = name;
	}

	public void show() {
		for (int i = 1; i <= 10; i++) {
			try {
				Thread.sleep(100);
				System.out.println("i=" + i + "\tname=" + name);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	@Override
	public void run() {
		show();
		
	}
}
