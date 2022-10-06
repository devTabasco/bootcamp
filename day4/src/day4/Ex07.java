package day4;

import java.util.Scanner;

public class Ex07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		System.out.print("단 입력 : ");
		int i = sc.nextInt();
		
		System.out.print("단 입력 : ");
		int j = sc.nextInt();
		
		System.out.println();

		System.out.printf("%d단\t\t%d단\n",i,j);
		for(int k = 1;k<10;k++) {
			System.out.printf("%d * %d = %d\t%d * %d = %d\n",i,k,i*k,j,k,j*k);
		}
		
		
		
	}

}
