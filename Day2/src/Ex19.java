import java.util.Scanner;

public class Ex19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("초간단 계산기 만들기");
		System.out.println();

		String operator = "";
		String str = "";
		float result = 0;
		
		System.out.println("1.더하기 / 2.빼기 / 3.곱하기 / 4.나누기");
		System.out.print("사칙연산 선택 : ");
		int a = sc.nextInt();
//		String str = (a==1)?"더하기":(a==2)?"빼기":(a==3)?"곱하기":"나누기";
		
		System.out.print("첫번째 숫자 : ");
		int num1 = sc.nextInt();

		System.out.print("두번째 숫자 : ");
		int num2 = sc.nextInt();
		
		if(a == 1) {
			str = "더하기";
			operator = "+";
			result = num1+num2;
		}else if (a == 2) {
			str = "빼기";
			operator = "-";			
			result = num1-num2;
		}else if (a == 3) {
			str = "곱하기";
			operator = "*";			
			result = num1*num2;
		}else if (a == 4) {
			str = "나누기";
			operator = "/";			
			result = num1/num2;
		}else {
			System.out.println("값을 제대로 입력하세요!");
		}
		
		if(a<5) {
		System.out.println();
		System.out.println(str+" 선택");
		System.out.println(num1+operator+num2+" = "+result);
		}
	}

}
