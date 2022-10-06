package day4;

import java.util.Scanner;

public class Ex09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//while statement
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("단 입력 : ");
		int num = sc.nextInt();
		int i = 1;
		
		System.out.println();
		
//		while(i<10) {
//			System.out.printf("%d * %d = %d\n",num,i,num*i);
//			i++;
//		}
		
		boolean check = true;
		
		while (check) {
			System.out.printf("%d * %d = %d\n",num,i,num*i);
			i++;
			if(i>9) {
				check = false;
			}
		}
		

	}

}
