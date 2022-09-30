package ex01;

import java.util.Scanner;

public class Ex08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름을 입력해주세요 : ");
		String name = sc.nextLine();
		
		System.out.print("나이를 입력해주세요 : ");
		int age = sc.nextInt();
		
		System.out.print("몸무게를 입력해주세요 : ");
		float weight = sc.nextFloat();
		
		System.out.print("결혼여부를 입력해주세요 : ");
		boolean isMarried = sc.nextBoolean();
		
		System.out.println();
		System.out.println("당신의 정보는 다음과 같습니다.");
		System.out.println("이름 : "+name+" 입니다.");
		System.out.println("나이 : "+age+"세");
		System.out.println("몸무게 : "+weight+"kg");
		System.out.println("결혼 : "+isMarried);
		
		sc.close();

	}

}
