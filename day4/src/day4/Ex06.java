package day4;

import java.util.Scanner;

public class Ex06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		for(int i=2;i<10;i++) {
			System.out.printf("%d단 시작\n",i);
			for(int j=1;j<10;j++) {
				System.out.printf("%d * %d = %d\n",i,j,i*j);
			}
		}
		
//		System.out.print("원하는 단을 입력해주세요 : ");
//		int i = sc.nextInt();sc.nextLine();
//			for(int j=1;j<10;j++) {
//				if(j==1) {
//					System.out.printf("%d단 시작\n",i);
//				}
//				System.out.printf("%d * %d = %d\n",i,j,i*j);
//			}
	}
}
