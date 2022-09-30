package ex01;

import java.util.Scanner;

public class Ex07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.print("이름 입력 : ");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		
		System.out.print("나이 입력 : ");
		String age = sc.nextLine();
		
		System.out.println();
		System.out.println("당신의 이름은 "+name+" 입니다.");
		System.out.println("당신의 나이은 "+age+" 입니다.");
		
		sc.close();

	}

}
