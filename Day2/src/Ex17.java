import java.util.Scanner;

public class Ex17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("초간단 학점 계산기");
		System.out.println();
		
		System.out.print("점수를 입력하세요 : ");
		Scanner sc = new Scanner(System.in);
		int score = sc.nextInt();
		char rank = 0;
		
		if(score>= 90 && score <=100) {
			rank = 'A';
//			System.out.println("A학점 입니다.");
		}else if (score>= 80 && score <=89) {
			rank = 'B';
//			System.out.println("B학점 입니다.");
		}
		else if (score>= 70 && score <=79) {
			rank = 'C';
//			System.out.println("C학점 입니다.");
		}
		else if (score>= 60 && score <=69) {
			rank = 'D';
//			System.out.println("D학점 입니다.");
		}else {
			rank = 'F';
//			System.out.println("F학점 입니다.");
		}
		
		switch (score) {
		case 100:
		case 99:
		case 98:
		case 97:
		case 96:
			rank = 'A'; // 100~96까지 모두 A로 출력
			break;
		default:
			break;
		}
		
		
		System.out.println(rank+"학점 입니다.");

	}

}
