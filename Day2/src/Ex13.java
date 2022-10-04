import java.util.Scanner;

public class Ex13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//switch-case
		Scanner sc = new Scanner(System.in);
		
		switch (sc.nextInt()%3) {
		case 0:
			System.out.println("3의 배수입니다.");
			break;
		case 1:
			System.out.println("3으로 나눴을 때, 나머지가 1입니다.");
			break;
		case 2:
			System.out.println("3으로 나눴을 때, 나머지가 2입니다.");
			break;
		default:
			break;
		}

	}

}
