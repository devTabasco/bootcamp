package day4;

import java.util.Scanner;

public class Ex13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		long account = 100000000;
		int menu = 0;
		long i = 0;
		boolean check = true;

		System.out.printf("희망 은행 : 현재 잔액 : %,d원\n", account);
		System.out.println();

		while (check) {
			System.out.println("1.입금 / 2.출금 / 3.잔액 / 4.종료");
			System.out.print("메뉴선택 : ");
			if (sc.hasNextInt()) {
				menu = sc.nextInt();sc.nextLine();

				//입금
				if (menu == 1) {
					System.out.print("입금금액 : ");
					i = sc.nextLong();
					if(i>0) {
						account += i;
						System.out.println("입금완료");						
					}else {
						System.err.println("해당금액은 입금이 불가능합니다.");
					}
				
				//출금
				} else if (menu == 2) {
					System.out.print("출금금액 : ");
					i = sc.nextLong();
					if(i>0) {
						if (account >= i) {
							account -= i;
							System.out.println("출금완료");
						} else {
							System.out.println("잔액초과");
						}						
					}else {
						System.err.println("해당 금액은 출금이 불가능합니다.");
					}
				
				//잔액조회
				} else if (menu == 3) {
					System.out.printf("잔액 : %,d원\n", account);
				
				//종료
				} else if (menu == 4) {
					check = false;
				}else {
					System.out.println("메뉴번호를 선택해주세요.");					
				}
			} else {
				System.out.println("숫자를 입력해주세요.");
				sc.nextLine();
			}

		}
		System.out.println("종료");

	}

}
