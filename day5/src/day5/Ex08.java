package day5;

import java.util.Scanner;

public class Ex08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String id = "test";
		String pw = "1234";
		
		System.out.println("초간단 로그인 체크");
		System.out.print("id를 입력하세요 : ");
		String loginId = sc.nextLine();
		System.out.print("pw를 입력하세요 : ");
		String loginPw = sc.nextLine();
		
		if(id.equals(loginId) && pw.equals(loginPw)) {
			System.out.printf("성공 : 반가워요(%s)님\n",id);
		}else {
			System.out.println("실패 : 해당정보가 없습니다.");
		}
		
		sc.close();
	}

	
}
