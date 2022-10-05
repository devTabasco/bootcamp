import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫 번째 숫자 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("두 번째 숫자 입력 : ");
		int num2 = sc.nextInt();
		System.out.print("세 번째 숫자 입력 : ");
		int num3 = sc.nextInt();
		
//		int result = (num1>=num2)?(num1>=num3)?num1:(num2>=num3)?num1:num2:num3;
		
		int result = 0;
		
		if(num1>=num2 && num1>=num3) {
			result = num1;
		}else if (num2>=num3) {
			result = num2;
		}else {
			result = num3;
		}
		
		System.out.println("가장 큰 숫자는 : "+result);

	}

}
