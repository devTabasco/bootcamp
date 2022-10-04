import java.util.Scanner;

public class Ex14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("두 수를 입력 받아 큰 값을 출력하시오");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫번째 숫자를 입력하세요 : ");
		int num1 = sc.nextInt();
		
		System.out.print("두번째 숫자를 입력하세요 : ");
		int num2 = sc.nextInt();
		
//		int result = 0;
//		
//		if(num1>=num2) {
//			result = num1;
//		}else {
//			result = num2;
//		}
		
		int result = (num1>=num2)?num1:num2;
		
		System.out.println("더 큰 값은 "+result+"입니다.");

	}

}
