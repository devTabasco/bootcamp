import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("초간단 학점 계산기");
		System.out.println();
		
		System.out.print("점수를 입력하세요 : ");
		int num = sc.nextInt();
		
		if(num>90) {
			System.out.println("A학점 입니다.");
		}else if(num>80){
			System.out.println("B학점 입니다.");			
		}else if(num>70){
			System.out.println("C학점 입니다.");			
		}else if(num>60){
			System.out.println("D학점 입니다.");			
		}else {
			System.out.println("F학점 입니다.");
		}

	}

}
