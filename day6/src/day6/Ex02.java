package day6;

import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String id = "test";
		String pw = "1234";
		String loginId = "";
		String loginPw = "";
		
		boolean loginCK = false;
		boolean run = true;
		
		while (run) {
		
		if(!loginCK) {
			
			System.out.println("1.회원가입 2.로그인 3.성적등록 4.성적리스트 0.종료");
			System.out.print("메뉴 선택 : ");
			int menu = sc.nextInt();sc.nextLine();
			
			switch (menu) {
			case 1:
				System.out.println("회원가입");
				break;
			case 2:
				System.out.print("id입력 : ");
				loginId = sc.nextLine();
				System.out.print("pw입력 : ");
				loginPw = sc.nextLine();
				
				if(id.equals(loginId) && pw.equals(loginPw)) {
					System.out.println("로그인 성공");
					loginCK = true;
				}else {
					System.out.println("회원정보를 확인해주세요.");
				}
				
				break;
			case 3:
				System.out.println("로그인 후 등록 가능합니다.");
				break;
			case 4:
				System.out.println("로그인 후 조회 가능합니다.");
				break;

			default:
				break;
			}
		}else {
			
			System.out.println("1.회원정보수정 2.로그아웃 3.성적등록 4.성적리스트 0.종료");
			System.out.print("메뉴 선택 : ");
			int menu = sc.nextInt();sc.nextLine();
			
			switch (menu) {
			case 1:
				System.out.println("회원정보 수정");
				break;
			case 2:
				System.out.println("안녕히가세요.");
				run = false;
				break;
			case 3:
				System.out.println("성적 등록");
				break;
			case 4:
				System.out.println("리스트 조회");
				break;

			default:
				break;
			}
		}
		
		}
		
		
	}

}
