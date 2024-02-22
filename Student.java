package edu.java.homework;

import java.io.Serializable;

public class Student implements Serializable{

	private String name;
	private int Eng;
	private int Math;
	
	public Student(String name, int eng, int math) {
		
		this.name = name;
		Eng = eng;
		Math = math;
	}

	public Student() {
		
		}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEng() {
		return Eng;
	}

	public void setEng(int eng) {
		Eng = eng;
	}

	public int getMath() {
		return Math;
	}

	public void setMath(int math) {
		Math = math;
	}

	public void displayinfo() {
		System.out.println("이름 : " + name + ", " + "수학 : " + Math + ", " + "영어 : " + Eng );
	


	}
		
	
	
}
