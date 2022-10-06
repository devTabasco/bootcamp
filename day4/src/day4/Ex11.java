package day4;

import java.util.Scanner;

public class Ex11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String name = "";
		
		System.out.println("초간단 자판기 만들기");
		System.out.println("메뉴 선택");
		System.out.println("1.커피 2.아이스커피 3.우유 4.사이다");
		
		System.out.println();
		System.out.printf("메뉴를 선택하세요 : ");
		Scanner sc = new Scanner(System.in);
		int menu = sc.nextInt(); sc.nextLine();
		
		if(menu == 1) {
			name = "커피";
		}else if(menu == 2) {
			name = "아이스커피";
			
		}else if(menu == 3) {
			name = "우유";
			
		}else if(menu == 4) {
			name = "사이다";
		}else {
			
		}
		
		System.out.printf("선택메뉴 : %s",name);

	}

}
