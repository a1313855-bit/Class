package threadEx;

public class AddBus {

	public static void main(String[] args) {
		Bus b1=new Bus();
		Bus b2=new Bus();
		Bus b3=new Bus();
		
		b1.start();
		b2.start();
		b3.start();
	}

}
