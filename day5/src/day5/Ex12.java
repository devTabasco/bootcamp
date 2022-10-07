package day5;

import java.util.Scanner;

public class Ex12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int answer = (int) (Math.random()*10)+1;
		boolean run = true;
		int count = 0;
		
		while (run) {
			System.out.println("숫자 Up&Down 시작!");
			System.out.print("1부터 10사이의 숫자를 입력해주세요! : ");
			int a = sc.nextInt();
			if(answer==a) {
				count++;
				System.out.printf("정답은 %s입니다.\n",answer);
				System.out.println("게임 종료");
				System.out.printf("시도한 횟수는 %d번 입니다.\n",count);
				run = false;
			}else if(answer<a) {
				sc.nextLine();
				count++;
				System.out.println("더 작은 수를 입력해주세요.");
			}else if(answer>a) {
				count++;
				System.out.println("더 큰 수를 입력해주세요.");				
			}else {
				System.out.println("ddd");
			}
		}
		


	}

}
