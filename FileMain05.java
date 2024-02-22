package edu.java.file05;

import java.io.EOFException;
import java.io.FileInputStream;

import java.io.InputStream;
import java.io.ObjectInputStream;

import edu.java.file04.MemberVO;

// 프로그램 <==== ObjectInputStream <=== FileInputStream <=== 파일(HDD)
public class FileMain05 {

	public static void main(String[] args) {
		InputStream in = null;
		ObjectInputStream oin = null;

		try {
			in = new FileInputStream("temp/member.txt");
			oin = new ObjectInputStream(in);
			while (true) {
				try {
					MemberVO m = (MemberVO) oin.readObject();
					System.out.println(m);
				} catch (EOFException e) {
					break;
				}
			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	} // end main()

} // end FileMain05
