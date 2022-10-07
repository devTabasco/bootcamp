package day5;

import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		
//		System.out.print("이름 입력 : ");
//		String name = scanner.nextLine();
//		System.out.print("나이 입력 : ");
//		String age = scanner.nextLine();
//		
//		System.out.printf("당신의 이름은 %s 입니다.\n",name);
//		System.out.printf("당신의 나이는 %s 입니다.\n",age);

		String name = "홍길동";
		int age = 27;
		float weight = 77.4f;
		boolean marriage = true;
		
		System.out.printf("이름 : %s 입니다.\n",name);
		System.out.printf("나이 : %d세\n",age);
		System.out.printf("몸무게 : %.1fkg\n",weight);
		System.out.printf("결혼 : %b\n",marriage);
		
		scanner.close();
		
		
	}

}
