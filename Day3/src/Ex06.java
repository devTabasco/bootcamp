import java.util.Scanner;

public class Ex06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int num = 0;
		
		if(sc.hasNextInt()) {
			System.out.println("숫자 입력 : ");
			num = sc.nextInt();
		}else {
			System.out.println("숫자만 입력해주세요.");
			sc.nextLine(); //버퍼 초기화
		}
		System.out.println("이름 입력 : ");
		String name = sc.nextLine();

	}

}
