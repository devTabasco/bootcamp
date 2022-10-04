import java.util.Scanner;

public class Ex07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("세 개의 숫자를 입력 받은 후 가장 큰 숫자를 출력.");
		
		Scanner sc = new Scanner(System.in);
		
		int result = 0;
		
		System.out.print("1번재 숫자 입력 : ");
		int num1 = sc.nextInt();
		
		System.out.print("2번재 숫자 입력 : ");
		int num2 = sc.nextInt();
		
		System.out.print("3번재 숫자 입력 : ");
		int num3 = sc.nextInt();
		
		if(num1>=num2) {
			result = num1;
		}
		else if(num2>=num3) {
			result = num2;
		}
		else {
			result = num3;
		}
		
		System.out.println();
		System.out.println("결과출력");
		System.out.println("가장 큰 숫자는 : " + result);
		
	}

}
