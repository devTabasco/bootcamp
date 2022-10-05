import java.awt.Checkbox;
import java.util.Scanner;

public class Ex11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		String name = "";
		String id = "";
		String pw = "";
		boolean check = true;

		//while문 시작
		while(check) {
			
			System.out.println("1.회원가입 2.로그인 3.종료 4.회원정보확인");
			System.out.print("메뉴 선택 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
		if(menu == 1) {
			System.out.println("회원가입");
			System.out.print("이름 입력 : ");
			name = sc.nextLine();
			System.out.print("아이디 입력 : ");
			id = sc.nextLine();
			System.out.print("pw 입력 : ");
			pw = sc.nextLine();
			System.out.println("회원가입 성공");
		}else if (menu == 2) {
			System.out.println("로그인");
			System.out.print("아이디 입력 : ");
			String loginId = sc.nextLine();
			System.out.print("pw 입력 : ");
			String loginPw = sc.nextLine();
			
			if(loginId.equals(id) && loginPw.equals(pw)) {
				System.out.println("로그인 성공!");
			}else {
				System.out.println("로그인 실패");
			}
			
			check = false;
		}else if(menu == 3) {
			System.out.println("종료");
			check = false;
		}else if(menu == 4) {
			System.out.println("회원정보 확인");
			System.out.printf("이름 : %s",name);
			System.out.printf("아이디 : %s",id);
			System.out.printf("비밀번호 : %s",pw);
		}else {
			System.err.println("메뉴 번호 확인");
		}
	}
		
//		switch (menu) {
//		case 1:
//			System.out.println("회원가입");
//			System.out.print("이름 입력 : ");
//			name = sc.nextLine();
//			System.out.print("아이디 입력 : ");
//			id = sc.nextLine();
//			System.out.print("pw 입력 : ");
//			pw = sc.nextLine();
//			break;
//		case 2:
//			System.out.println("로그인");
//			System.out.print("아이디 입력 : ");
//			String loginId = sc.nextLine();
//			System.out.print("pw 입력 : ");
//			String loginPw = sc.nextLine();
//			
//			if(loginId.equals(id) && loginPw.equals(pw)) {
//				System.out.println("로그인 성공!");
//			}else {
//				System.out.println("로그인 실패");
//			}
//			
//			break;
//		case 3:
//			System.out.println("종료");
//			break;
//		default:
//			System.out.println("메뉴 번호 확인");
//			break;
//		}
//		
//		System.out.println("1.회원가입 2.로그인 3.종료");
//		System.out.print("메뉴 선택 : ");
//		menu = sc.nextInt();
//		sc.nextLine();
//		
//		switch (menu) {
//		case 1:
//			System.out.println("회원가입");
//			System.out.print("이름 입력 : ");
//			name = sc.nextLine();
//			System.out.print("아이디 입력 : ");
//			id = sc.nextLine();
//			System.out.print("pw 입력 : ");
//			pw = sc.nextLine();
//			break;
//		case 2:
//			System.out.println("로그인");
//			System.out.print("아이디 입력 : ");
//			String loginId = sc.nextLine();
//			System.out.print("pw 입력 : ");
//			String loginPw = sc.nextLine();
//			
//			if(loginId.equals(id) && loginPw.equals(pw)) {
//				System.out.println("로그인 성공!");
//			}else {
//				System.out.println("로그인 실패");
//			}
//			
//			break;
//		case 3:
//			System.out.println("종료");
//			break;
//		default:
//			System.out.println("메뉴 번호 확인");
//			break;
//		}


	}

}
