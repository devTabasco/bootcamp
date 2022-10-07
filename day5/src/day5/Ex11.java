package day5;

import java.util.Scanner;

public class Ex11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		boolean run = true;
		int menu = 0;
		
		while(run) {
		System.out.println("1.중식 2.한식 3.종료");
		System.out.print("메인메뉴선택 : ");
		if(sc.hasNextInt()) {
			menu = sc.nextInt();sc.nextLine();
			
			if(menu == 1) {
				System.out.println("중식메뉴를 선택 하세요.");
				System.out.println("1.짜장면 2.짬뽕 3.만두");
				System.out.print("중식메뉴 : ");
				menu = sc.nextInt();sc.nextLine();
				if(menu == 1) {
					System.out.println("짜장면 선택");
				}else if(menu == 2) {
					System.out.println("짬뽕 선택");
				}else if(menu == 3) {
					System.out.println("만두 선택");
				}else {
					
				}
			}else if(menu == 2) {
				System.out.println("한식메뉴를 선택 하세요.");
				System.out.println("1.불고기 2.한정식 3.갈비");
				System.out.print("한식메뉴 : ");
				menu = sc.nextInt();sc.nextLine();
				if(menu == 1) {
					System.out.println("불고기 선택");
				}else if(menu == 2) {
					System.out.println("한정식 선택");
				}else if(menu == 3) {
					System.out.println("갈비 선택");
				}else {
					
				}
			}else if(menu == 3) {
				System.out.println("종료");
				run = false;
			}
		}else {
			System.out.println("메뉴 번호를 확인하세요!");
			sc.nextLine();
		}
		
		
		}
		
	}

}
