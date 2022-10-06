package day4;

import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String id = "test";
		String pw = "1234";
		
		System.out.println("초간단 로그인 체크");
		System.out.println();
		
		System.out.print("id를 입력하세요 : ");
		String loginId = sc.nextLine();

		System.out.print("pw를 입력하세요 : ");
		String loginPw = sc.nextLine();
		
		if(loginId.equals(id)&&loginPw.equals(pw)) {
			System.out.printf("성공 : 반가워요(%s님)\n",id);
		}else {
			System.out.println("실패 : 해당정보가 없습니다.");
		}
	}

}
