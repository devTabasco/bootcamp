package day5;

import java.util.Scanner;

public class Ex10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String name = "테스터";
		String id = "test";
		String pw = "1234";
		int menu = 0;
		String phone = "01000000000";
		
		boolean loginCK = false;
		boolean check = true;
		
		while(check) {
		
		if(loginCK) {
			
			System.out.printf("1.회원정보 수정 2.로그아웃(%s)님 3.회원정보 확인 4.종료\n",name);
			System.out.print("메뉴 선택 : ");
			menu = sc.nextInt();sc.nextLine();
			
			switch (menu) {
			case 1: //회원정보 수정
				System.out.println("1.이름 수정 2.아이디 수정 3.비밀번호 수정 4.나가기");
				System.out.print("메뉴 선택 : ");
				menu = sc.nextInt();sc.nextLine();
				
				switch (menu) {
				case 1:
					while(true) {
						System.out.println("변경할 이름 입력 : ");
						name = sc.nextLine();
						
						if(name.length()>1) {
							System.out.println("이름이 성공적으로 변경되었습니다.");
							break;
						}else {
							System.out.println("이름은 2자 이상 입력해주세요.");
						}
					}
					break;
				case 2:
					System.out.print("현재 아이디 입력 : ");
					if(id.equals(sc.nextLine())) {
						while(true) {
							System.out.print("변경할 아이디 입력 : ");
							id = sc.nextLine();
							
							if(id.length()>=4) {
								System.out.println("아이디가 성공적으로 변경되었습니다.");
								break;
							}else {
								System.out.println("이름은 2자 이상 입력해주세요.");
							}
						}
					}else {
						System.out.println("아이디를 다시 확인해주세요.");
					}
					break;
				case 3:
					System.out.print("현재 비밀번호 입력 : ");
					if(pw.equals(sc.nextLine())) {
						while(true) {
							System.out.print("변경할 비밀번호 입력 : ");
							pw = sc.nextLine();
							
							if(pw.length()>=4) {
								System.out.println("비밀번호가 성공적으로 변경되었습니다.");							
								break;
							}else {
								System.out.println("비밀번호는 2자 이상 입력해주세요.");
							}
						}
					}else {
						System.out.println("비밀번호를 다시 확인해주세요.");
					}
					break;
				case 4:
					break;
				default:
					System.out.println("메뉴 번호를 확인해주세요.");
					break;
				}
				break;
			case 2:
				loginCK = false;
				System.out.println("로그아웃 성공");
				break;
			case 3:
				System.out.print("핸드폰 번호 입력 : ");
				if(phone.equals(sc.nextLine())) {
					System.out.printf("이름 : %s, 아이디 : %s, 비밀번호 : %s\n",name,id,pw);
				}else {
					System.out.println("핸드폰 번호를 다시 확인해주세요.");
					System.err.println("Hint : 이 프로그램 개발자 번호");
				}
				break;
			case 4:
				check = false;
				System.out.println("프로그램 종료");
				break;
			default:
				System.out.println("메뉴 번호를 확인해주세요.");
				break;
			}
		}else {
			System.out.println("1. 회원가입 2.로그인 3.종료");
			System.out.print("메뉴 선택 : ");
			menu = sc.nextInt();sc.nextLine();
			if(menu == 1) {
				System.out.println("회원가입");
				
				while(true) {
					System.out.print("이름 : ");
					name = sc.nextLine();
					
					if(name.length()>1) {
						break;
					}else {
						System.out.println("이름은 2자 이상 입력해주세요.");
					}
				}
				
				while(true) {
					System.out.print("ID : ");
					id = sc.nextLine();
					
					if(id.length()>=4) {
						break;
					}else {
						System.out.println("이름은 4자 이상 입력해주세요.");
					}
				}
				
				while(true) {
					System.out.print("PW : ");
					pw = sc.nextLine();
					
					if(pw.length()>=4) {
						break;
					}else {
						System.out.println("비밀번호는 4자 이상 입력해주세요.");
					}
				}
				
			}else if(menu == 2) {
				System.out.print("ID : ");
				String loginId = sc.nextLine();
				System.out.print("PW : ");
				String loginPw = sc.nextLine();
				
				if(id.equals(loginId) && pw.equals(loginPw)) {
					loginCK = true;
				}else {
					System.out.println("회원 정보를 확인해주세요.");
				}
			}else if(menu == 3) {
				check = false;
			}else {
				System.out.println("메뉴 번호를 확인해주세요.");
			}
			
			}
		}
		

	}

}
