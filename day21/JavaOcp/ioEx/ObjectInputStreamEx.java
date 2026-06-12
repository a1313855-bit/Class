package ioEx;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/*
 * 1.FileInputStream-->開啟舊檔+讀取資料流方向
 * 2.串接->ObjectInputStream
 */

public class ObjectInputStreamEx {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileInputStream fis=new FileInputStream("c:/ioExam/Student.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		
		while(true)
		{
			try
			{
				((Student)ois.readObject()).show();
			}
			catch(java.io.EOFException e)
			{
				
			}
		
		
		}
		
		
		
		//System.out.println(ois.readObject());
		//((Student)ois.readObject()).show();
		//((Student)ois.readObject()).show();

	}

}
