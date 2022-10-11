package day6;

import java.util.Scanner;

public class Ex01_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		
		while (run) {
			
		System.out.println("1.회원가입 2.로그인 3.종료");
		System.out.print("메뉴 선택 : ");
		
		int menu = sc.nextInt(); sc.nextLine();
		
		switch (menu) {
		case 1:
			System.out.println("회원가입");
			break;
		case 2:
			System.out.println("로그인");
			break;
		case 3:
			System.out.println("종료");
			run = false;
			break;
		default:
			break;
			
			}
		}
		

	}

}
