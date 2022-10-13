package day7;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
			
			System.out.print("어떤 연산을 하실건가요? ex)+,-,*,/");
			String str = sc.nextLine();
			System.out.print("계산할 첫 번째 숫자를 입력해주세요 : ");
			double num1 = sc.nextInt();sc.nextLine();
			System.out.print("계산할 두 번째 숫자를 입력해주세요 : ");
			double num2 = sc.nextInt();sc.nextLine();
			
			System.out.println(calculrator(str,num1,num2));
		
	}
	
	static String calculrator(String str, double a, double b) {
		
		String operator = str;
		double result;
		
		if(operator.equals("+")) {
			result = a+b;
			return String.format("%.1", String.valueOf(result));
		}else if(operator.equals("-")) {
			result = a-b;
			return String.valueOf(result);
		}else if(operator.equals("*")) {
			result = a*b;
			return String.valueOf(result);
		}else if(operator.equals("/")) {
			result = a/b;
			try {
				return String.valueOf(result);
			} catch (ArithmeticException e) {
				return "";
			}
			
		}else {
			return "연산자를 확인하세요.";
		}
	}

}
