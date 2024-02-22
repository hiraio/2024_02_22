package edu.java.file06;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import edu.java.file04.MemberVO;


// 프로그램 ===> ObjectOutputStream ===> BufferedOutputStream ===> FileOutputStream ===> 파일(HDD)
public class FileMain06 {

	public static void main(String[] args) {
		System.out.println("ArrayList<MemberVO> 객체를 파일에 저장하고 읽어오는 코드");

		/* 데이터를 ArrayList에 저장하는 코드 */
		OutputStream out = null;
		BufferedOutputStream bout = null;
		ObjectOutputStream oout = null;
		
		try {
			out = new FileOutputStream("temp/list.txt");
			bout = new BufferedOutputStream(out);
			oout = new ObjectOutputStream(bout);
			
			long startTime = System.currentTimeMillis();
			List<MemberVO> list = new ArrayList<>();
			for(int i = 0; i < 1000000; i++) {
				String id = "member" + i;
				String pw = "pw" + i;
				MemberVO m = new MemberVO(i, id, pw);
				list.add(m);
			}
			
			oout.writeObject(list);
			long endTime = System.currentTimeMillis();
			System.out.println("복사 경과 시간 : " + (endTime - startTime));
			System.out.println("데이터 저장 완료");
			
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
		
	} // end main()

} // end FileMain06









