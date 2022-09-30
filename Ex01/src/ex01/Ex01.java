package ex01;
import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름을 입력해주세요 : ");
		String name = sc.nextLine();
		
		System.out.print("나이를 입력해주세요 : ");
		String age = sc.nextLine();
		
		System.out.println(name+"입니다.");
		System.out.print("나이는 "+age+"살 입니다.");
		
//		System.out.println("초간단 자판기 만들기");
//		System.out.println("메뉴 선택");
//		System.out.println("1.커피 2.아이스커피 3.우유 4.사이다");
//		System.out.println("메뉴번호를 선택하세요 : 4");
//		System.out.println("선택메뉴 : 사이다");
		
		sc.close();

	}

}
