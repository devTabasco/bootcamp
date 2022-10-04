import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("이름은?");
		String name = sc.nextLine();
		
		System.out.println("나이는?");
		int age = sc.nextInt();
		
		System.out.println("몸무게?");
		float weight = sc.nextFloat();
		
		System.out.println("결혼여부?");
		boolean marriage = sc.nextBoolean();

		
		System.out.println("이름 : "+name+" 입니다.");
		System.out.println("나이 : "+age+"세");
		System.out.println("몸무게 : "+weight+"kg");
		System.out.println("결혼 : "+marriage);
		
		sc.close();

	}

}
