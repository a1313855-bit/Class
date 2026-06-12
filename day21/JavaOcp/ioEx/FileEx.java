package ioEx;

import java.io.File;
import java.io.IOException;

public class FileEx {

	public static void main(String[] args) throws IOException{
		/*File f=new File("c:/ABC/a.txt");
		f.createNewFile();*/
		
		File f=new File("c:/ioExam/A/B/C/D");
		f.mkdirs();

	}

}
