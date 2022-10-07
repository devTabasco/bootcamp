package day5;

import java.util.Scanner;

public class Ex13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int answer = (int) (Math.random()*10)+1;
		
		System.out.println("숫자 업다운");
		
		while(true) {
			System.out.println("숫자입력");
			int answer1 = sc.nextInt();
			if(answer1>answer) {
				System.out.println("더 작은 수");
			}else if(answer>answer1) {
				System.out.println("더 큰 수");
			}else {
				System.out.println("성공");
				break;
			}
		}

	}

}
