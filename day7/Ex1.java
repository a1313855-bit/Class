//mathods應用

class Ex1
{
	public static void main(String[] args) {
		Order o1=new Order("abc",1,1,2,1);
		Order o2=new Order("def",1,2,2,1);
		o1.show();
		o2.show();

		System.out.println("===================");
		//o1.changeOrder1(3,3,3);
		//o2.changeOrder1(2,1,3);

		System.out.println("合計="+(o1.changeOrder2(3,3,3)+o2.changeOrder2(2,1,3)));
		o1.show();
		o2.show();
		System.out.println("===================");

		/*System.out.println(o1.name+"\tlcd="+o1.lcd);
		o1.name="rrrr";
		o1.lcd=-20;*/
		System.out.println(o1.getName());
		o1.show();
		System.out.println("===================");
		o1.setName("abcdddd");
		o1.setLcd(20);
		o1.show();
	}
}