import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
	
		System.out.println("초간단 자판기 만들기");
		System.out.println("메뉴 선택");
		System.out.println("1.커피 / 2.아이스커피 / 3.우유 / 4.사이다");
		
		System.out.print("메뉴 번호를 선택하세요 : ");
		String str = "";
		
		switch (sc.nextInt()) {
		case 1:
			str = "커피";
			break;
		case 2:
			str = "아이스커피";
			break;
		case 3:
			str = "우유";
			break;
		case 4:
			str = "사이다";
			break;
		default:
			System.out.println("정확한 숫자를 입력해주세요.");
			break;
		}
		System.out.println("선택메뉴 : "+str);
		
		sc.close();

	}

}
