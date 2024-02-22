package edu.java.homework;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 임창준_HW6 {

	public static void main(String[] args) {
		System.out.println("데이터 입력 및 저장하는 코드 작성");
		
		OutputStream out = null;
		BufferedOutputStream bout = null;
		ObjectOutputStream oout = null;
		
		try {
			out = new FileOutputStream("temp/list.txt");
			bout = new BufferedOutputStream(out);
			oout = new ObjectOutputStream(bout);
			
			Scanner sc = new Scanner(System.in);
			List<Student> list = new ArrayList<>();
			for(int i = 0; i < 6; i++) {
				String name =sc.next();
				int Math = sc.nextInt();
				int Eng = sc.nextInt();
				
				Student stu = new Student(name , Math , Eng);
				list.add(stu);
		 
			}
			oout.writeObject(list);
			
		} catch (FileNotFoundException e) {
			System.out.println(e.toString());
		} catch (IOException e) {
			System.out.println(e.toString());
		} finally {
			try {
				oout.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// ---------------------------------------------------------

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
		
	} // end main()

} // end HW6
