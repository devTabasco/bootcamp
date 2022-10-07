package day5;

import java.util.Scanner;

public class Ex09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("초간단 성적 계산기");
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("국어 : ");
		int kor = sc.nextInt();sc.nextLine();
		System.out.print("영어 : ");
		int eng = sc.nextInt();sc.nextLine();
		System.out.print("수학 : ");
		int math = sc.nextInt();sc.nextLine();
		
		
		String grade = "";
		float avg = (kor+eng+math)/3.0f;
		
		if(avg >=90) {
			grade = "A";
		}else if(avg >=80) {
			grade = "B";			
		}else if(avg >=70) {
			grade = "C";			
		}else if(avg >=60) {
			grade = "D";			
		}else {
			grade = "F";
		}
		
		System.out.printf("총점 : %d 평균 %.1f %s학점 입니다.",kor+eng+math,avg,grade);
		
	}

}
