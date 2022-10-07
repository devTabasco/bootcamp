package day5;

import java.util.Scanner;

public class Ex15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("회원관리");
		
		boolean run = true;
		String name = "";
		String name1 = "";
		int age = 0;
		int age1 = 0;
		int count = 0;
		
		while(run) {
		System.out.print("1.등록 | 2.리스트 | 3.종료 : ");
		int menu = sc.nextInt();sc.nextLine();
		if(menu == 1) {
			
			if(count == 0) {
				System.out.println("회원등록");
				System.out.print("이름을 입력하세요 : ");
				name = sc.nextLine();
				System.out.print("나이를 입력하세요 : ");
				age = sc.nextInt();sc.nextLine();
				System.out.println("회원등록 완료");
				count++;
			
			}else if(count==1) {
				System.out.println("회원등록");
				System.out.print("이름을 입력하세요 : ");
				name1 = sc.nextLine();
				System.out.print("나이를 입력하세요 : ");
				age1 = sc.nextInt();sc.nextLine();
				System.out.println("회원등록 완료");
				count++;
			}else {
				
			}
		}else if(menu == 2) {
			System.out.println("회원리스트");
			System.out.printf("이름\t나이\n");
			System.out.println("-------------");
			System.out.printf("%s\t%d\n",name,age);
			System.out.printf("%s\t%d\n",name1,age1);
		}else if(menu == 3) {
			run = false;
		}else {
			
		}
		}
		
//		System.out.printf("");

	}

}
