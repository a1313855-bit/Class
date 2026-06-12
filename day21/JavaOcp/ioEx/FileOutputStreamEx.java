package ioEx;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class FileOutputStreamEx {

	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("c:/ioExam/ex2.txt");
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osw);

		bw.write("巨匠電腦abceee");
		bw.close();

		/*
		 * FileOutputStream fos=new FileOutputStream("c:/ioExam/ex2.txt");
		 * OutputStreamWriter osw=new OutputStreamWriter(fos); osw.write("abcddeee巨匠");
		 * osw.close();
		 */

		/*
		 * FileOutputStream fos=new FileOutputStream("c:/ioExam/ex2.txt"); byte[] x=new
		 * byte[] {66,67,68,69}; fos.write(x);
		 */

	}

}
