import java.util.Scanner;

public class Ex15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String name = "";
		int count = 0;
		int price = 0;
		int choice = 0;

		System.out.println("초간단 과일 자판기");
		System.out.println("1.사과 2,000원");
		System.out.println("2.수박 6,000원");
		System.out.println("3.복숭아 4,000원");
		System.out.println();

		System.out.print("과일을 선택하세요 : ");
		choice = sc.nextInt();sc.nextLine();
		
		switch (choice) {
		case 1:
			name = "사과";
			price = 2000;
			break;
		case 2:
			name = "수박";
			price = 6000;
			break;
		case 3:
			name = "복숭아";
			price = 4000;
			break;
		default:
			break;
		}
		
		System.out.print("수량을 입력 하세요 : ");
		count = sc.nextInt();sc.nextLine();
		
		System.out.println();
		System.out.printf("%s %d개 %,d원 입니다!",name,count,price*count);

	}

}
