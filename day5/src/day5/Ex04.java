package day5;

import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("초간단 자판기 만들기");
		System.out.println("메뉴 선택");
		System.out.println("1.커피 2.아이스커피 3.우유 4.사이다");
		
		System.out.print("메뉴 번호를 선택하세요 : ");
		int menu = scanner.nextInt();scanner.nextLine();
		
		System.out.println("1.if문 2.switch문");
		System.out.print("원하는 유형을 선택하세요 : ");
		int type = scanner.nextInt();scanner.nextLine();
		
		if(type == 1) {
			if(menu == 1) {
				System.out.println("선택메뉴 : 커피");
			}else if(menu == 2) {
				System.out.println("선택메뉴 : 아이스커피");				
			}else if(menu == 3) {
				System.out.println("선택메뉴 : 우유");				
			}else if(menu == 4) {
				System.out.println("선택메뉴 : 사이다");				
			}else {
				System.out.println("메뉴 번호 입력");
			}
			
		}else if(type == 2) {
			switch (menu) {
			case 1:
				System.out.println("선택메뉴 : 커피");
				break;
			case 2:
				System.out.println("선택메뉴 : 아이스커피");
				break;
			case 3:
				System.out.println("선택메뉴 : 우유");
				break;
			case 4:
				System.out.println("선택메뉴 : 사이다");
				break;
			default:
				System.out.println("메뉴 번호 입력");
				break;
			}

		}

	}

}
