import java.util.Scanner;

public class Ex13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String id = "test";
		String pw = "1234";
		
		System.out.println("초간단 로그인 체크");
		System.out.println();
		
		System.out.print("id를 입력하세요 : ");
		String loginId = sc.nextLine();
		System.out.print("pw를 입력하세요 : ");
		String loginPw = sc.nextLine();
		
		if(loginId.equals(id)) {
			if(loginPw.equals(pw)) {
				System.out.printf("성공 : 반가워요(%s)님\n",id);
			}else {
				System.out.println("비밀번호가 틀렸습니다.");
			}
		}else if(!loginPw.equals(pw)) {
			System.out.println("둘다 틀렸습니다.");
		}else {
			System.out.println("아이디가 틀렸습니다.");
		}

	}

}
