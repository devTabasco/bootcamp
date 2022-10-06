package day4;

import java.util.Scanner;

public class Ex08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		System.out.print("단 입력 : ");
		int i = sc.nextInt();
		
		System.out.print("단 입력 : ");
		int j = sc.nextInt();
		
		System.out.println();
		
		for(int k = 1;k<10;k++) {
			if(k==1) {
				for(int l=i;l<=j;l++) {
					System.out.printf("%d단\t\t",l);
				}
				System.out.println();
			}
			for(int a = i; a<=j; a++) {
				
				System.out.printf("%d * %d = %d\t",a,k,a*k);
			}
			System.out.println();
		}
		
	}
}
