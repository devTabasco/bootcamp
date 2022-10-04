import java.util.Scanner;

public class Ex16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("초간단 성적 계산기");
		System.out.println();
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		System.out.print("국어점수 : ");
		int korean = sc.nextInt();
		
		System.out.print("영어점수 : ");
		int english = sc.nextInt();

		System.out.print("수학점수 : ");
		int math = sc.nextInt();
		
		int total = korean + english + math;
		float avg = total/3;
		
		System.out.println();
		System.out.println(name+"님");
		System.out.println("총점 : "+total+" 평균 : "+avg+"입니다.");
	}

}
