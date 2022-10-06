package day4;

import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String name = "";
		int count = 0;
		int price = 0;
		int menu = 0;
		
		System.out.printf("1.사과 2000원\n2.수박 6000원\n3.복숭아 4000원\n");
		System.out.print("과일을 선택하세요 : ");
		menu = sc.nextInt(); sc.nextLine();
		System.out.print("구입 수량을 입력하세요 : ");
		count = sc.nextInt(); sc.nextLine();
		
		if(menu == 1) {
			name = "사과";
			price = 2000;
		}else if(menu == 2) {
			name = "수박";
			price = 6000;			
		}else if(menu == 3) {
			name = "복숭아";
			price = 4000;			
		}else {
			System.out.println("과일 번호를 선택해주세요.");
		}
		
		System.out.println();
		System.out.printf("%s %d개 %,d원 입니다.",name,count,count*price);

	}

}
