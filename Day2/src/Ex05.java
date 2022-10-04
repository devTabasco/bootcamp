import java.awt.print.Printable;
import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("초간단 계산기 만들기");
		System.out.println();
		System.out.println("1.더하기 / 2.빼기 / 3.곱하기 / 4.나누기");
		
		System.out.print("사칙연산 선택 : ");
		int menu = sc.nextInt();
		
		System.out.print("첫번째 숫자 : ");
		int num1 = sc.nextInt();
		System.out.print("두번째 숫자 : ");
		int num2 = sc.nextInt();
		
		System.out.println();
		System.out.println("결과출력");
		
		String menuName ="";
		String operator = "";
		int result = 0;
		
		if(menu == 1) {
			menuName = "더하기";
			System.out.println(menuName+" 선택");
			System.out.println(num1+"+"+num2+" = "+(num1+num2));
		}
		else if(menu == 2) {
			menuName = "빼기";
			System.out.println(menuName+" 선택");
			System.out.println(num1+"-"+num2+" = "+(num1-num2));
		}
		else if(menu == 3) {
			menuName = "곱하기";
			System.out.println(menuName+" 선택");
			System.out.println(num1+"*"+num2+" = "+(num1*num2));
		}
		else if(menu == 4) {
			menuName = "나누기";
			System.out.println(menuName+" 선택");
			System.out.println(num1+"/"+num2+" = "+(num1/(float)num2));
		}
		else {
			System.out.println("숫자를 정확히 입력해주세요.");
		}

	}

}
