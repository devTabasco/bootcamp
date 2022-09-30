package ex01;
import java.util.Scanner;

public class Ex06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc =  new Scanner(System.in);
		
		System.out.println("초간단 회원가입");
		System.out.println();
		
		System.out.print("이름을 입력하세요 : ");
		String name = sc.nextLine();
		
		System.out.print("id를 입력하세요 : ");
		String id = sc.nextLine();
		
		System.out.print("pw를 입력하세요 : ");
		String pw = sc.nextLine();
		
		System.out.println();
		System.out.println("회원가입 성공");
		System.out.println("이름 : "+name);
		System.out.println("Id : "+id);
		System.out.println("Pw : "+pw);
		
		sc.close();

	}

}
