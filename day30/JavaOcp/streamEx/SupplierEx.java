package streamEx;

import java.util.function.Supplier;

public class SupplierEx {
	public static void main(String[] args) {
		String title="巨匠電腦";
		Supplier<String> s1=()->title;
		System.out.println(s1.get());
		
		Supplier<Member> s2=()->new Member();
		System.out.println(s2.get().getName());
		
		Member m=s2.get();
		System.out.println(m.getName()+"\t"+m.getAddress());
		
	}
}

class Member{
	private String name;
	private String address;
	public Member() {
		super();
		this.name="abc";
		this.address="taipei";
	}
	public Member(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
