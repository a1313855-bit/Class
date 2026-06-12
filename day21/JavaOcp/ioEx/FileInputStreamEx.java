package ioEx;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileInputStreamEx {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("c:/ioExam/ex2.txt");
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		int i = 0;
		while ((i = br.read()) != -1) {
			System.out.print((char) i);
		}

		/*
		 * FileInputStream fis=new FileInputStream("c:/ioExam/ex2.txt");
		 * InputStreamReader isr=new InputStreamReader(fis); int i=0;
		 * while((i=isr.read())!=-1) { System.out.print((char)i); }
		 */

		// System.out.println((char)isr.read());

		// System.out.println((char)fis.read());

	}
}
