import java.util.Scanner;

public class Ex11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("3의 배수를 입력해보세요 : ");
		int a = sc.nextInt();
		
		if(a%3==0) {
			System.out.println("3의 배수 입니다.");
		}
		else {
			System.out.println("3의 배수가 아닙니다.");
		}
		

	}

}
