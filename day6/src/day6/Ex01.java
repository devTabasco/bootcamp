package day6;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		boolean loginCk = false;
		int menu = 0;
		String name = "";
		String id = "";
		String pw = "";
		String loginId = "";
		String loginPw = "";
		String list = "", listName = "";
		int kor = 0, eng = 0, math = 0;
		boolean idCK = true;

		while (run) {
			if (!loginCk) {
				System.out.println("1. 회원가입 2.로그인 3.성적등록 4.성적리스트 0.종료");
				System.out.print("메뉴선택 : ");
				if (sc.hasNextInt()) {
					menu = sc.nextInt();
					sc.nextLine();

					switch (menu) {
					case 1:
						System.out.println("회원가입 선택");
						System.out.print("이름을 입력하세요 : ");
						name = sc.nextLine();
						while(idCK) {							
							System.out.print("id를 입력하세요 : ");
							loginId = sc.nextLine();
							if(loginId.equals(id)) {
								System.out.println("중복된 아이디가 있습니다.");
							}else if(loginId.length()<=1){
								System.out.println("아이디는 2자 이상 가능합니다.");
							}else {
								idCK = false;
								id = loginId;								
							}
						}
						idCK = true;
						
						while(true) {
							
						System.out.print("pw를 입력하세요 : ");
						pw = sc.nextLine();
						if(pw.length()>=4) {
							break;
						}else {
							System.out.println("비밀번호는 4자 이상 가능합니다.");
						}

						}
						System.out.println();
						System.out.println("회원가입 성공");
						System.out.printf("이름 : %s\nId : %s\nPw : %s\n", name, id, pw);

						break;
					case 2:
						System.out.println("로그인 선택");
						System.out.print("id를 입력하세요 : ");
						loginId = sc.nextLine();
						System.out.print("pw를 입력하세요 : ");
						loginPw = sc.nextLine();

						if (id.equals(loginId) && pw.equals(loginPw)) {
							System.out.printf("로그인 성공 : 반가워요(%s님)\n", name);
							loginCk = true;
						} else {
							System.out.println("회원정보를 확인해주세요.");
						}
						break;
					case 3:
						System.err.println("로그인 후 등록 가능합니다.");
						break;
					case 4:
						System.err.println("로그인 후 조회 가능합니다.");
						break;
					case 0:
						System.out.println("프로그램 종료");
						run = false;
					default:
						break;
					}
				} else {
					System.out.println("메뉴번호를 확인해주세요.");
					sc.nextLine();
				}
			} // loginCk true
			else {
				System.out.printf("1.비밀번호 수정 2.로그아웃(%s)님 3.성적등록. 4.성적리스트 0.종료\n", name);
				System.out.print("메뉴 선택 : ");
				if(sc.hasNextInt()) {
					menu = sc.nextInt();
					sc.nextLine();

					switch (menu) {
					case 1:
						System.out.print("변경할 비밀번호 입력 : ");
						pw = sc.nextLine();
						System.out.println("비밀번호 변경 완료");
						break;
					case 2:
						System.out.println("로그아웃");
						loginCk = false;
						break;
					case 3:
						System.out.println("성적등록");
						System.out.print("이름 : ");
						listName = sc.nextLine();

						System.out.print("국어 성적 : ");
						kor = sc.nextInt();

						System.out.print("영어 성적 : ");
						eng = sc.nextInt();

						System.out.print("수학 성적 : ");
						math = sc.nextInt();

						int total = (kor + eng + math);
						float avg = total / (float) 3;

						list += (listName + "\t" + kor + "\t" + eng + "\t" + math + "\t" + total + "\t"
								+ String.format("%.2f", avg) + "\t" + getGrade(avg) + "\n");
						break;
					case 4:
						System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t등급");
						System.out.println("------------------------------------------------------");
						System.out.printf(list);
						break;

					case 0:
						System.out.println("종료");
						run = false;
						break;
					default:
						break;
					}
				}else {
					System.out.println("메뉴 번호를 확인해주세요.");
				}
				
			}

		} // run

	}

	static String getGrade(float avg) {

		if (avg >= 90) {
			return "A";
		} else if (avg >= 80) {
			return "B";
		} else if (avg >= 70) {
			return "C";
		} else if (avg >= 60) {
			return "D";
		} else {
			return "F";
		}
	}

}
