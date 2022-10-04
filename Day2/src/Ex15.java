import java.util.Scanner;

public class Ex15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("점수를 입력하세요 : ");
//		int result = sc.nextInt();
//		
//		if(result>=60) {
//			System.out.println("합격");
//		}else {
//			System.out.println("불합격");
//		}
		
		System.out.println((sc.nextInt()>=60)?"합격":"불합격");

	}

}
