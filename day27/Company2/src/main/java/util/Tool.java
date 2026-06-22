package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import entity.Member;
import entity.Porder;

public class Tool {

	public static void main(String[] args) {
		// 寫入測試
		// Member member=new Member("Mr.D","ddd","1234","new taipei
		// city","0900000011","0200000011");
		// Tool.save_file("member.txt", member);

		// 讀出測試
		//System.out.println(Tool.read_file("porder.txt"));
		
		//嘗試讀出資料
		Member member=(Member) Tool.read_file("member.txt");
		System.out.println("name:"+member.getName()+"\t"+"phone:"+member.getPhone());
		
		Porder porder=(Porder) Tool.read_file("porder.txt");
		System.out.println("name:"+porder.getName()+"\t"+"sum:"+porder.getSum());
		
	}

	// ===================寫入===================//

	public static void save_file(String file_name, Object object) {
		try {
			FileOutputStream fos = new FileOutputStream(file_name);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(object);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// ===================讀出===================//

	public static Object read_file(String file_name) {
		Object object = new Object();
		try {
			FileInputStream fis = new FileInputStream(file_name);
			ObjectInputStream ois = new ObjectInputStream(fis);
			object = ois.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return object;
	}

}
