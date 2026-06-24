package lambdaEx;

interface Book2<E>{
	E bookPrice(E price);
}

public class Ex2 {

	public static void main(String[] args) {
		Book2<Integer> b1=new Book2<>() {

			@Override
			public Integer bookPrice(Integer price) {
				// TODO Auto-generated method stub
				return price;
			}
		};
		
		Book2<Double> b2=(price)->price;
		
		System.out.println(b1.bookPrice(1000));
		
		System.out.println(b2.bookPrice(1000.0));

	}

}
