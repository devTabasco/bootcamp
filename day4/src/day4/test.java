package day4;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		String name = "";
		String id = "";
		String pw = "";
		
		boolean check = true;
		
		while(check) {
		
		System.out.println("1.회원가입 2.로그인 3.종료");
		System.out.print("메뉴선택 : ");
		int menu = scanner.nextInt(); scanner.nextLine();
		
		//회원가입
		if(menu == 1) {
			System.out.println("회원가입");
			
			System.out.print("이름 : ");
			name = scanner.nextLine();
			
			System.out.print("아이디 : ");
			id = scanner.nextLine();
			
			System.out.print("비밀번호 : ");
			pw = scanner.nextLine();
			
			System.out.println("회원가입이 완료되었습니다.");
		
		//로그인
		}else if(menu == 2){
			System.out.println("로그인");
			
			System.out.print("로그인 아이디 입력 : ");
			String loginId = scanner.nextLine();
			
			System.out.print("로그인 비밀번호 입력 : ");
			String loginPw = scanner.nextLine();
			
			if(loginId.equals(id)&&loginPw.equals(pw)) {
				System.out.printf("%s님 환영합니다.\n",id);
				
				System.out.println("1.회원정보 수정 2.로그아웃 3.종료");
				System.out.print("메뉴 선택 : ");
				menu = scanner.nextInt(); scanner.nextLine();
				
				//로그인 후 출력 화면 control
				if(menu == 1) {
					System.out.println("1.이름 수정 2.아이디 수정 3.비밀번호 수정 4.로그아웃");
					System.out.print("메뉴 선택 : ");
					menu = scanner.nextInt(); scanner.nextLine();
					
					if(menu == 1) {
						System.out.println("이름 수정");
						System.out.print("변경할 이름 입력 : ");
						name = scanner.nextLine();
						System.out.println("이름 변경 완료");
						
					}else if(menu == 2) {
						System.out.println("아이디 수정");
						System.out.print("기존 아이디 입력 : ");
						if(id.equals(scanner.nextLine())) {
							System.out.print("신규 아이디 입력 : ");
							id = scanner.nextLine();
							System.out.println("아이디 변경 완료");
						}else {
							System.out.println("아이디를 확인해주세요.");
						}
						
					}else if(menu == 3) {
						System.out.println("비밀번호 수정");
						System.out.print("기본 비밀번호 입력 : ");
						if(pw.equals(scanner.nextLine())) {
							System.out.print("신규 비밀번호 입력 : ");
							pw = scanner.nextLine();
							System.out.println("비밀번호 변경 완료");
						}else {
							System.out.println("비밀번호를 확인해주세요.");
						}
					}else if(menu == 4){
						
					}else {
						System.out.println("회원정보를 확인하세요.");
					}
				}else if(menu == 2) {
					System.out.println("로그아웃");
				}else if(menu == 3) {
					System.out.println("종료");
					check = false;
				}else {
					System.out.println("메뉴 번호를 다시 눌러주세요.");
				}
				
			}else {
				System.out.println("회원정보를 확인하세요.");
			}

			
		//종료	
		}else if(menu == 3){
			System.out.println("종료");
			check = false;
		
		//에러
		}else {
			System.out.println("메뉴 번호를 선택하세요.");
			System.out.println();
		}
		
		}
		
		scanner.close();

	}

}
