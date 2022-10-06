package day5;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		boolean run = true;
		boolean loginCK = false;
		String id = "";
		String pw = "";
		String name = "";
		int menu = 0;
	
		while (run) {
			if (loginCK) {
				System.out.printf("1.정보수정 2. 로그아웃(%s님) 3. 종료\n", name);
			} else {
				System.out.println("1.회원가입 2. 로그인 3. 종료");
			}
			System.out.print("메뉴선택 : ");
			if(sc.hasNextInt()) {
				menu = sc.nextInt();sc.nextLine();
			}else {
				sc.nextLine();
			}
			switch (menu) {
			case 1:
				if (loginCK) {
					
					System.out.println("1.이름 수정 2.아이디 수정 3.비밀번호 수정 4.나가기");
					menu = sc.nextInt();sc.nextLine();
					switch(menu) {
					case 1:
						System.out.println("이름 수정");
						System.out.print("변경할 이름 입력 : ");
						name = sc.nextLine();
						System.out.println("이름 변경 완료");
						break;
					case 2:
						System.out.println("아이디 수정");
						System.out.print("현재 아이디 입력 : ");
						if(id.equals(sc.nextLine())) {
							System.out.print("변경할 아이디 입력 : ");
							id = sc.nextLine();
							System.out.println("아이디 변경 완료");
							System.out.println("재로그인 해주세요.");
							loginCK = false;
						}else {
							System.out.println("아이디가 틀렸습니다.");							
						}
						break;
					case 3:
						System.out.println("비밀번호 수정");
						System.out.print("현재 비밀번호 입력 : ");
						if(pw.equals(sc.nextLine())) {
							System.out.print("변경할 비밀번호 입력 : ");
							pw = sc.nextLine();
							System.out.println("비밀번호 변경 완료");	
							System.out.println("재로그인 해주세요.");
							loginCK = false;
						}else {
							System.out.println("비밀번호가 틀렸습니다.");							
						}
						break;
					case 4:
						break;
					default:
							System.out.println("메뉴번호를 선택해주세요.");
						break;
					}

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
	}

}
