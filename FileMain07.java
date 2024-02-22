package edu.java.file07;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import edu.java.file04.MemberVO;

public class FileMain07 {

	public static void main(String[] args) {
		System.out.println("파일에 저장된 ArrayList<MemberVO> 객체를 읽어오는 코드");
		
		InputStream in = null;
		BufferedInputStream bin = null;
		ObjectInputStream oin = null;
 
		
		try {
			in = new FileInputStream("temp/list.txt");
			bin = new BufferedInputStream(in);
			oin = new ObjectInputStream(bin);
			
			ArrayList<MemberVO> list = (ArrayList<MemberVO>) oin.readObject();
			
			for(MemberVO m : list) {
				System.out.println(m);
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
