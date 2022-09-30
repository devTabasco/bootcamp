package ex01;
import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("초간단 회원가입");
		
		System.out.print("이름을 입력하세요 : ");
		String name =  scanner.nextLine();
		
		System.out.print("id를 입력하세요 : ");
		String id =  scanner.nextLine();
		
		System.out.print("pw를 입력하세요 : ");
		String pw =  scanner.nextLine();
		
		System.out.println();
		System.out.println("회원가입 성공");
		System.out.println("이름 : " + name);
		System.out.println("Id : " + id);
		System.out.println("Pw : " + "*".repeat(pw.length()));
		
		scanner.close();
	}

}
