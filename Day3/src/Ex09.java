import java.util.Scanner;

public class Ex09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.println(name+"입니다.");
		
		System.out.print("나이 : ");
		int age = sc.nextInt();
		sc.nextLine(); //buffer clear
		System.out.println(age+"세");

		System.out.print("취미 : ");
		String hobby = sc.nextLine();
		System.out.println(hobby+"입니다.");
	}

}
