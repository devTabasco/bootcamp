import java.util.Scanner;

public class Ex12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("아이디 입력 : ");
		String id = sc.nextLine();
		
		System.out.print("로그인 아이디 입력 : ");
		String loginId = sc.nextLine();
		
		if(id.equals(loginId)) {
			System.out.println("환영합니다.");
		}else{
			System.out.println("id를 다시 확인해보세요.");
		};

	}

}
