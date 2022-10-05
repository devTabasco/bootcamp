import java.util.Scanner;

//import java.text.NumberFormat;

public class Ex05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Number comma test
		
		String name = "홍길동";
		int age = 21;
		int money = 21000000;
		float avg = 90.8384f;
		
		System.out.println("이름 "+name+" 나이 "+age+" 평균 "+avg);
		System.out.printf("이름 %s 나이 %,d 평균 %.2f\n",name,age,avg);
		
//		NumberFormat.getNumberInstance().format(1000);
		
		System.out.printf("[%10s]",name);
		System.out.printf("[%.2s]",name);
		
	}

}
