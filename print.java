package edu.java.homework;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class print {

	public static void main(String[] args) {

		InputStream in = null;
		BufferedInputStream bin = null;
		ObjectInputStream oin = null;
		
		Student m = new Student();
		try {
			in = new FileInputStream("temp/list.txt");
			bin = new BufferedInputStream(in);
			oin = new ObjectInputStream(bin);
			
			ArrayList<Student> list = (ArrayList<Student>) oin.readObject();
			
			for(Student stu : list) {
				stu.displayinfo();
			}
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		finally {
			try {
				oin.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
