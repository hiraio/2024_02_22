package edu.java.file04;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

// 프로그램 ===> ObjectOutputstream ===> FileOutputStream ===> 파일 (HDD)

public class FileMain04 {

	public static void main(String[] args) {
		OutputStream out = null;
		ObjectOutputStream oout = null;
		
		System.out.println("파일 저장 성공!");
		
		try {
			out = new FileOutputStream("temp/member.txt");
			oout = new ObjectOutputStream(out);
			
			MemberVO m1 = new MemberVO(1, "root1" , "root123");
			oout.writeObject(m1);
			
			MemberVO m2 = new MemberVO(2, "root2" , "root123");
			oout.writeObject(m2);
			
			MemberVO m3 = new MemberVO(3, "root3" , "root123");
			oout.writeObject(m3);
			
			
		} catch (Exception e) {
			System.out.println("예외 발생 : " + e.toString());				
		} finally {
			try {
				// 리소스(oout)를 해제할 때는 최종적으로 생성된 리소스만 해제하면,
				// 그 리소스(oout)가 사용하고 있는 다른 리소스(out)들도 순차적으로 해제됨
				oout.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	} // end main()

} // end FileMain04
