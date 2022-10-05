import java.util.Scanner;

public class Ex14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("나이 입력 : ");
		System.out.println((sc.nextInt()>=20)?"성인 입니다.":"청소년 입니다.");

	}

}
