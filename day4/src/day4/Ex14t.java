package day4;

import java.util.Scanner;

public class Ex14t {
	public static void main(String[] args) {
		boolean run = true;
		boolean loginCK = false;
		String id = "";
		String pw = "";
		String name = "";
		while (run) {
			if (loginCK) {
				System.out.printf("1.정보수정 2. 로그아웃(%s님) 3. 종료\n", name);
			} else {
				System.out.println("1.회원가입 2. 로그인 3. 종료");
			}
			System.out.print("메뉴선택 : ");
			Scanner sc = new Scanner(System.in);
			int menu = sc.nextInt();
			sc.nextLine();
			switch (menu) {
			case 1:
				if (loginCK) {
					System.out.print("비밀번호 수정 : ");
					pw = sc.nextLine();					
					System.out.println("비밀번호 수정완료");
				} else {
					System.out.println("회원가입");
					System.out.print("이름 : ");
					name = sc.nextLine();
					System.out.print("id : ");
					id = sc.nextLine();
					System.out.print("pw : ");
					pw = sc.nextLine();
					System.out.println("회원가입완료");
				}
				break;
			case 2:
				if (loginCK) {
					loginCK = false;
					System.out.println("로그아웃");
				} else {
					System.out.println("로그인");
					System.out.print("id : ");
					String loginID = sc.nextLine();
					System.out.print("pw : ");
					String loginPW = sc.nextLine();
					if (id.equals(loginID) && pw.equals(loginPW)) {
						System.out.println(name + "님 반가워요");
						loginCK = true;
					} else {
						System.out.println("로그인 정보가 없습니다.");
					}
				}

				break;
			case 3:
				System.out.println("종료");
				run = false;
				break;
			default:
				System.out.println("메뉴번호 확인");
				break;
			}
		}
//		회원가입 선택
//		1.회원가입 2. 로그인 3. 종료
//		메뉴선택 : 2
//		로그인 선택
//		1.회원가입 2. 로그인 3. 종료
//		메뉴선택 : 3
//		프로그램 종료

	}

}
