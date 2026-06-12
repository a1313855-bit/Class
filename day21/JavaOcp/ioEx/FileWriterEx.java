package ioEx;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterEx {

	public static void main(String[] args)  {
		
		
		try(FileWriter fw = new FileWriter("c:/ioExam/ex1.txt");)
		{
			fw.write("abcdef巨匠電腦");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		/*FileWriter fw=new FileWriter("c:/ioExam/ex1.txt");
		fw.write("abcdef巨匠電腦");
		fw.close();*/

	}

}
