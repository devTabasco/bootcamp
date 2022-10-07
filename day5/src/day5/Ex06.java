package day5;

import java.util.Scanner;

public class Ex06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int account = 100000000;
		int input = 0;
		boolean check = true;
		
		while (check) {
			System.out.printf("희망은행 : 현재잔액 : %,d원\n",account);
			System.out.println("1.입금 2.출금 3.잔액 4.종료");
			System.out.print("메뉴선택 : ");
			int menu = sc.nextInt();sc.nextLine();
			
			switch (menu) {
			case 1:
				System.out.print("입금 금액 : ");				
				input = sc.nextInt();sc.nextLine();
				if(input >= 0) {
					account += input;
					System.out.println("입금 완료");					
				}else {
					System.out.println("입금 금액 확인");
				}
				break;
				
			case 2:
				System.out.print("출금 금액 : ");
				input = sc.nextInt();sc.nextLine();
				
				if(input>=0 && account>=input) {
					account -= input;
					System.out.println("출금 완료");					
				}else {
					System.err.println("출금 금액 확인");
				}
				break;
			
			case 3:
				System.out.printf("잔액 : %,d원\n",account);
				break;
				
			case 4:
				System.out.println("종료");
				check = false;
				break;
			default:
				System.out.println("메뉴 번호 확인");
				break;
			}
			
		}
		
		
		

	}

}
