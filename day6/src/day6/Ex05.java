package day6;

import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String id = "test", pw = "1234", name = "테스터", loginId = "", loginPw = "";
		int account = 0, tmp = 0;
		
		boolean run = true;
		boolean loginCK = false;
		boolean subrun = true;
		
		while(run) {
			if(!loginCK) {
				System.out.println("1.회원가입 2.로그인 3.자판기 4.은행입출근 0.종료");
				int menu = sc.nextInt();sc.nextLine();
				
				switch (menu) {
				case 1:
					System.out.println("회원가입");
					break;
				case 2:
					System.out.print("id : ");
					loginId = sc.nextLine();
					System.out.print("pw : ");
					loginPw = sc.nextLine();
					
					if(loginId.equals(id) && loginPw.equals(pw)) {
						System.out.println("로그인 성공");
						loginCK = true;
					}else {
						System.out.println("회원정보를 확인해주세요.");
					}
					
					break;
				case 3:
					System.out.println("로그인 후 이용가능");
					break;
				case 4:
					System.out.println("로그인 후 이용가능");
					break;
				case 0:
					System.out.println("종료");
					run = false;
					break;
				default:
					break;
				}
				
			}else {
				System.out.printf("1.회원정보수정 2.로그아웃(%s)님 3.자판기 4.은행입출근 0.종료\n",name);
				int menu = sc.nextInt();sc.nextLine();
				
				switch (menu) {
				case 1:
					System.out.println("회원정보 수정");
					break;
				case 2:
					System.out.printf("로그아웃(%s)님\n",name);
					loginCK = false;
					break;
				case 3:
					System.out.println("1.사과 2,000원 2.수박 6,000원 3.복숭아 4,000원");
					System.out.print("메뉴 선택 : ");
					menu = sc.nextInt();sc.nextLine();
					
					switch (menu) {
					case 1:
						System.out.println("사과 2,000원");
						break;
					case 2:
						System.out.println("수박 6,000원");
						break;
					case 3:
						System.out.println("복숭아 4,000원");
						break;
					default:
						break;
					}
					
					break;
				case 4:
					System.out.println("은행 입출금");
					while(subrun) {
						System.out.printf("현재잔액 : %,d원\n",account);
						System.out.println("1.입금 2.출금 3.잔액 4.종료");
						System.out.print("메뉴 선택 : ");
						menu = sc.nextInt();sc.nextLine();
						
						switch (menu) {
						case 1:
							System.out.print("입금 금액 : ");
							tmp = sc.nextInt();sc.nextLine();
							account += tmp;
							
							break;
						case 2:
							System.out.print("출금 금액 : ");
							tmp = sc.nextInt();sc.nextLine();
							account -= tmp;
							break;
						case 3:
							System.out.println("잔액조회");
							System.out.printf("잔액 : %,d원\n",account);
							break;
						case 4:
							System.out.println("종료");
							subrun = false;
							break;
						default:
							break;
						}
					}
					break;
				case 0:
					System.out.println("종료");
					run = false;
					break;
				default:
					break;
				}
			}
		}
	}
}
