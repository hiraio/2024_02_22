package edu.java.file03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/*
1. 일반적인 try-catch-finally 구문 
	try {
      (실행문)
	} catch (Exception e) {
      (예외처리)
	} finally {
      (항상 실행할 코드들) // 리소스 삭제
	}
	
	2. try-with-resource 구문 : Java 7버전부터 제공
	- try() 안에서 생성된 리소스들의 해제 코드(close();)를 자동으로 호출해줌
	try(리소스 생성) {
   		(실행문)
	} catch (Exception e) {
   		(예외 처리)
	}
*/
 
public class FileMain03 {

	public static void main(String[] args) {
						
				InputStream in = null;
				OutputStream out = null;
				
				try {
					// FileXXXStream : 파일 입출력 객체. 통로 역할
					in = new FileInputStream("temp/big_text.txt");
					out = new FileOutputStream("temp/big_copy.txt");
					
					System.out.println("테스트 시작");
					int data = 0; // read() 메소드가 리턴하는 값을 저장할 변수
					int byteCopied = 0;
					byte[] buffer = new byte[1024 * 1024 * 245]; // 1MB 공간
					// 1KB = 1024 Bytes
					// 1MB = 1024 * 1024 Bytes	
					// 1GB = 1024 * 1024 * 1024 Bytes
					System.out.println("테스트 시작");
					long startTime = System.currentTimeMillis();

					while(true) {
						// read(byte[] b) :
						// 파일에서 읽은 데이터를 매개변수 배열 b에 저장
						// 실제로 읽은 바이트 수를 리턴, 파일 끝에서는 -1을 리턴
						
						data = in.read(buffer);
							if(data == -1) {
							break;
						}
						
						// write(byte[] b) :
						// - 매개변수 배열 b의 내용을 한 번에 파일에 씀
						out.write(buffer);
						
						byteCopied += data;
					}
					long endTime = System.currentTimeMillis();
					System.out.println("복사 경과 시간 : " +  (endTime - startTime));
					
					System.out.println(byteCopied + " 바이트 복사됨 ");
					
				} catch (FileNotFoundException e) {
					
					System.out.println(e.toString());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						in.close();
						out.close();	
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
				
			} // end main()
		 
	} // end FileMain03


