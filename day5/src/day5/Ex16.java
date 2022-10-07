package day5;

import java.util.Scanner;

public class Ex16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("회원관리");
		
		boolean run = true;
		String name = "";
		String age = "";
		String totalName = "";
		
		while(run) {
		System.out.print("1.등록 | 2.리스트 | 3.종료 : ");
		int menu = sc.nextInt();sc.nextLine();
		if(menu == 1) {
			
				System.out.println("회원등록");
				System.out.print("이름을 입력하세요 : ");
				name = sc.nextLine();
				totalName += name;
				totalName += "\t";
				System.out.print("나이를 입력하세요 : ");
				age = sc.nextLine();
				totalName += age;
				totalName += "\n";
				System.out.println("회원등록 완료");

		}else if(menu == 2) {
			System.out.println("회원리스트");
			System.out.printf("이름\t나이\n");
			System.out.println("-------------");
			System.out.printf("%s",totalName);
	
		}else if(menu == 3) {
			run = false;
		}else {
			
		}
		}
		

	}

}
