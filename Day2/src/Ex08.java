import java.util.Scanner;

public class Ex08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("초간단 자판기 만들기");
		System.out.println("메뉴 선택");
		System.out.println("1.커피 / 2.아이스커피 / 3.우유 / 4.사이다");
		System.out.print("메뉴번호를 선택하세요 : ");
		int menu = sc.nextInt();
		String menuName = "";
		
		if(menu==1) {
			menuName = "커피";
		}
		else if (menu==2) {
			menuName = "아이스커피";
		}
		else if (menu==3) {
			menuName = "우유";
		}
		else if (menu==4) {
			menuName = "사이다";
		}
		
		System.out.println("선택메뉴 : "+menuName);

	}

}
