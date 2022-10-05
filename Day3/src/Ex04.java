import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int account = 0;
		int menu = 0;
		int i = 0;
		boolean check = true;
		
		System.out.printf("희망 은행 : 현재 잔액 : %d원\n",account);
		System.out.println();
		
		while (check) {
			System.out.println("1.입금 / 2.출금 / 3.잔액 / 4.종료");
			System.out.print("메뉴선택 : ");
			if(sc.hasNextInt()) {
				menu = sc.nextInt();
				
				if(menu==1) {
					System.out.print("입금금액 : ");
					i = sc.nextInt();
					account += i;
					System.out.println("입금완료");
				}else if (menu==2) {
					System.out.print("출금금액 : ");
					i = sc.nextInt();
					if(account>=i) {
						account -= i;
						System.out.println("출금완료");
					}else {
						System.out.println("잔액초과");
					}
				}else if (menu==3) {
					System.out.printf("잔액 : %,d원\n",account);
				}else if (menu==4) {
					check = false;
				}
			}else {
				System.out.println("숫자를 입력해주세요.");
				check = false;
			}
			
	}
		
//		System.out.println("1.입금 / 2.출금 / 3.잔액 / 4.종료");
//		System.out.print("메뉴선택 : ");
//		menu = sc.nextInt();
//		
//		if(menu==1) {
//			System.out.print("입금금액 : ");
//			i = sc.nextInt();
//			account += i;
//			System.out.println("입금완료");
//		}else if (menu==2) {
//			System.out.print("출금금액 : ");
//			if(account>=i) {
//				i = sc.nextInt();
//				account -= i;
//				System.out.println("출금완료");
//			}else {
//				System.out.println("잔액초과");
//			}
//		}else if (menu==3)
//			System.out.println("잔액 : "+ account+"원");
//		}else if (menu==4) {
//			System.out.println();
//		}
//		
//		System.out.println("1.입금 / 2.출금 / 3.잔액 / 4.종료");
//		System.out.print("메뉴선택 : ");
//		menu = sc.nextInt();
//		
//		if(menu==1) {
//			System.out.print("입금금액 : ");
//			i = sc.nextInt();
//			account += i;
//			System.out.println("입금완료");
//		}else if (menu==2) {
//			System.out.print("출금금액 : ");
//			if(account>=i) {
//				i = sc.nextInt();
//				account -= i;
//				System.out.println("출금완료");
//			}else {
//				System.out.println("잔액초과");
//			}
//		}else if (menu==3) {
//			System.out.println("잔액 : "+account+"원");
//		}else if (menu==4) {
//			System.out.println();
//		}
//		
//		System.out.println("1.입금 / 2.출금 / 3.잔액 / 4.종료");
//		System.out.print("메뉴선택 : ");
//		menu = sc.nextInt();
//		
//		if(menu==1) {
//			System.out.print("입금금액 : ");
//			i = sc.nextInt();
//			account += i;
//			System.out.println("입금완료");
//		}else if (menu==2) {
//			System.out.print("출금금액 : ");
//			if(account>=i) {
//				i = sc.nextInt();
//				account -= i;
//				System.out.println("출금완료");
//			}else {
//				System.out.println("잔액초과");
//			}
//		}else if (menu==3) {
//			System.out.println("잔액 : "+account+"원");
//		}else if (menu==4) {
//			System.out.println();
//		}
//		
//		System.out.println("1.입금 / 2.출금 / 3.잔액 / 4.종료");
//		System.out.print("메뉴선택 : ");
//		menu = sc.nextInt();
//		
//		if(menu==1) {
//			System.out.print("입금금액 : ");
//			i = sc.nextInt();
//			account += i;
//			System.out.println("입금완료");
//		}else if (menu==2) {
//			System.out.print("출금금액 : ");
//			if(account>=i) {
//				i = sc.nextInt();
//				account -= i;
//				System.out.println("출금완료");
//			}else {
//				System.out.println("잔액초과");
//			}
//		}else if (menu==3) {
//			System.out.println("잔액 : "+account+"원");
//		}else if (menu==4) {
//			System.out.println();
//		}
//		
//		System.out.println("1.입금 / 2.출금 / 3.잔액 / 4.종료");
//		System.out.print("메뉴선택 : ");
//		menu = sc.nextInt();
//		
//		if(menu==1) {
//			System.out.print("입금금액 : ");
//			i = sc.nextInt();
//			account += i;
//			System.out.println("입금완료");
//		}else if (menu==2) {
//			System.out.print("출금금액 : ");
//			if(account>=i) {
//				i = sc.nextInt();
//				account -= i;
//				System.out.println("출금완료");
//			}else {
//				System.out.println("잔액초과");
//			}
//		}else if (menu==3) {
//			System.out.println("잔액 : "+account+"원");
//		}else if (menu==4) {
//			System.out.println();
//		}

	}

}
