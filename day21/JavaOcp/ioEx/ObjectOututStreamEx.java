package ioEx;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*
 * 1.FileOutputStream-->開新檔案+寫入資料流
 * 2.串接-->ObjectOutputstream-->writeObject
 */

public class ObjectOututStreamEx {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos=new FileOutputStream("c:/ioExam/Student.txt");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		
		oos.writeObject(new Student("a1",68,65) );
		oos.writeObject(new Student("a2",68,75) );
		oos.writeObject(new Student("a3",78,65) );
		oos.writeObject(new Student("a4",88,55) );
		oos.writeObject(new Student("a5",68,85) );
	}
}
