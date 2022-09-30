package ex01;

import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("초간단 회원가입");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름을 입력하세요 : ");
		String name = sc.nextLine();
		
		System.out.print("id를 입력하세요 : ");
		String id = sc.nextLine();
		
		System.out.print("pw 입력하세요 : ");
		String pw = sc.nextLine();
		
		System.out.println(" ");
		System.out.println("회원가입 성공");
		System.out.println("이름 : " + name + "입니다.");
		System.out.println("Id : " + id);
		System.out.println("Pw : " + pw);
		
		sc.close();

	}

}
