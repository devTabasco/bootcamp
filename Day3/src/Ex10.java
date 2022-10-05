import java.util.Scanner;

public class Ex10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("나이 : ");
		int age = sc.nextInt();
		
		if(age>=20) {
			System.out.println("성인");
		}else if(age>=15) {
			System.out.println("청소년");
		}else if(age>=8) {
			System.out.println("초등학생");
		}else {
			System.out.println("유치부");
		}
		
		

	}

}
