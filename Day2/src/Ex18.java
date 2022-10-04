import java.util.Scanner;

public class Ex18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("초간단 숫자 교환기");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
	
		int tmp = 0;
		
		System.out.print("num1 숫자 : ");
		int num1 = sc.nextInt();
		System.out.print("num2 숫자 : ");
		int num2 = sc.nextInt();
		
		System.out.println();
		System.out.println("숫자 교환 전");
		System.out.println("num1 숫자 : "+ num1);
		System.out.println("num2 숫자 : "+ num2);
		
		tmp = num2;
		num2 = num1;
		num1 = tmp;
		
		System.out.println();
		System.out.println("숫자 교환 후");
		System.out.println("num1 숫자 : "+ num1);
		System.out.println("num2 숫자 : "+ num2);

	}

}
