package ioEx;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx {
	public static void main(String[] args) throws IOException {
		FileReader fr=new FileReader("c:/ioExam/ex1.txt");
		
		/*System.out.println((char)fr.read());
		System.out.println((char)fr.read());*/
		
		int i=0;
		while((i=fr.read())!=-1)
		{
			System.out.print((char)i);
		}
	}
}
