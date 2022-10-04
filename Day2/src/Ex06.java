import java.util.Scanner;

public class Ex06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		
		if(age >= 20) {
			System.out.println("성인 입니다.");
		}
		else {
			System.out.println("청소년 입니다.");
		}
	}

}
