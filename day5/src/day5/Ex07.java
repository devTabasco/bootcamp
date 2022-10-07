package day5;

import java.util.Scanner;

public class Ex07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int account = 1000000;
		int fee = 0;
		String name = "";
		
		System.out.printf("현재 잔고 %d원\n",account);
		System.out.println("행복 과일");
		System.out.printf("1.사과 2,000원\n2.수박 6,000원\n3.복숭아 4,000원\n메뉴 선택 : ");
		int menu = sc.nextInt();sc.nextLine();
		
		if(menu == 1) {
			name = "사과";
			fee = 2000;
		}else if(menu == 2) {
			name = "수박";
			fee = 6000;
		}else if(menu == 2) {
			name = "복숭아";
			fee = 4000;
		}else {
			System.out.println("메뉴 번호를 선택해주세요.");
		}
		
		System.out.printf("%s 구매 개수 : ",name);
		int count = sc.nextInt();sc.nextLine();
		
		System.out.printf("선택한 %s %d개의 가격은 %,d입니다.\n",name,count,count*fee);
		
		System.out.printf("현재 잔고는 %,d원 입니다. 구매하시겠습니까?\n",account);
		System.out.print("1.구매 2.취소 : ");
		int choice = sc.nextInt();sc.nextLine();
		
		if(choice == 1) {
			account -= count*fee;
			System.out.println("구매완료");
			System.out.printf("구매 후 잔액 %,d원\n",account);
		}else if(choice ==2) {
			System.out.println("구매취소");
		}else {
			System.out.println("메뉴 번호를 선택해주세요.");			
		}

	}

}
