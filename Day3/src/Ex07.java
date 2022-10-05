import java.util.Scanner;

public class Ex07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 잔액 balance , 출금 withdraw, 입금 deposit
		
		Scanner sc = new Scanner(System.in);
		
		int balance = 0;
		int menu = 0;
		boolean check = true;
		
		System.out.printf("희망은행 : 현재잔액 : %,d원\n", balance);
		
		while(check) {
		System.out.println("1.입금 / 2.출금 / 3.잔액 / 4.종료");
		System.out.print("메뉴 선택 : ");
		if(sc.hasNextInt()) {
			menu = sc.nextInt();
			if(menu == 1) {
				System.out.print("입금금액 : ");
				int deposit = sc.nextInt();
				balance += deposit;
				System.out.println("입금완료");
			}else if (menu == 2) {
				System.out.print("출금금액 : ");
				int withdraw = sc.nextInt();
				if(withdraw<=balance) {
					balance -= withdraw;
					System.out.println("출금완료");
				}else {
					System.err.println("잔액부족");
				}
			}else if (menu == 3) {
				System.out.printf("잔액 : %,d원\n",balance);
			}else if (menu == 4) {
				System.out.println("종료");
				check = false;
			}else {
				System.out.println("메뉴번호를 선택해주세요.");
			}
		}else {
			System.out.println("메뉴 번호를 입력해주세요.");
			check= false;
		}
		}
		
//		System.out.println("1.입금 / 2.출금 / 3.잔액 / 4.종료");
//		System.out.print("메뉴 선택 : ");
//		menu = sc.nextInt();
//		
//		if(menu == 1) {
//			System.out.print("입금금액 : ");
//			int deposit = sc.nextInt();
//			balance += deposit;
//			System.out.println("입금완료");
//		}else if (menu == 2) {
//			System.out.print("출금금액 : ");
//			int withdraw = sc.nextInt();
//			balance -= withdraw;
//			System.out.println("출금완료");
//		}else if (menu == 3) {
//			System.out.printf("잔액 : %,d원\n",balance);
//		}else if (menu == 4) {
//			System.out.println("종료");
//		}else {
//			System.out.println("메뉴번호를 선택해주세요.");
//		}
//		
//		System.out.println("1.입금 / 2.출금 / 3.잔액 / 4.종료");
//		System.out.print("메뉴 선택 : ");
//		 menu = sc.nextInt();
//		
//		if(menu == 1) {
//			System.out.print("입금금액 : ");
//			int deposit = sc.nextInt();
//			balance += deposit;
//			System.out.println("입금완료");
//		}else if (menu == 2) {
//			System.out.print("출금금액 : ");
//			int withdraw = sc.nextInt();
//			balance -= withdraw;
//			System.out.println("출금완료");
//		}else if (menu == 3) {
//			System.out.printf("잔액 : %,d원\n",balance);
//		}else if (menu == 4) {
//			System.out.println("종료");
//		}else {
//			System.out.println("메뉴번호를 선택해주세요.");
//		}
//		
//		System.out.println("1.입금 / 2.출금 / 3.잔액 / 4.종료");
//		System.out.print("메뉴 선택 : ");
//		 menu = sc.nextInt();
//		
//		if(menu == 1) {
//			System.out.print("입금금액 : ");
//			int deposit = sc.nextInt();
//			balance += deposit;
//			System.out.println("입금완료");
//		}else if (menu == 2) {
//			System.out.print("출금금액 : ");
//			int withdraw = sc.nextInt();
//			balance -= withdraw;
//			System.out.println("출금완료");
//		}else if (menu == 3) {
//			System.out.printf("잔액 : %,d원\n",balance);
//		}else if (menu == 4) {
//			System.out.println("종료");
//		}else {
//			System.out.println("메뉴번호를 선택해주세요.");
//		}
//		
//		System.out.println("1.입금 / 2.출금 / 3.잔액 / 4.종료");
//		System.out.print("메뉴 선택 : ");
//		 menu = sc.nextInt();
//		
//		if(menu == 1) {
//			System.out.print("입금금액 : ");
//			int deposit = sc.nextInt();
//			balance += deposit;
//			System.out.println("입금완료");
//		}else if (menu == 2) {
//			System.out.print("출금금액 : ");
//			int withdraw = sc.nextInt();
//			balance -= withdraw;
//			System.out.println("출금완료");
//		}else if (menu == 3) {
//			System.out.printf("잔액 : %,d원\n",balance);
//		}else if (menu == 4) {
//			System.out.println("종료");
//		}else {
//			System.out.println("메뉴번호를 선택해주세요.");
//		}

	}

}
