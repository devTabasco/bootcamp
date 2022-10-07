package day5;

import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("초간단 메뉴 만들기");
		
		
		boolean check = true;
		while (check) {
			
			System.out.println("1.회원가입 2로그인 3.종료");
			System.out.print("메뉴 선택 : ");
			int menu = sc.nextInt();sc.nextLine();
			
//			if(menu == 1) {
//				System.out.println("회원가입 선택");				
//			}else if(menu == 2) {
//				System.out.println("로그인 선택");				
//			}else if(menu == 3) {
//				System.out.println("프로그램 종료");
//				check = false;				
//			}else {
//				
//			}
			
			switch (menu) {
			case 1:
				System.out.println("회원가입 선택");				
				break;
			case 2:
				System.out.println("로그인 선택");				
				break;
			case 3:
				System.out.println("프로그램 종료");
				break;
			default:
				break;
			}
		}
	}
}
