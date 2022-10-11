package day6;

import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String id = "test", pw = "1234", loginId = "", loginPw = "", name = "테스터", listName = "", list = "";
		int kor = 0, eng = 0, math = 0, total = 0;
		float avg = 0;
		boolean loginCK = false, run = true;
		
		while(run) {
		
		if(!loginCK) {
			
		System.out.println("1.회원가입 2.로그인 3.성적등록 4.리스트 0.종료");		
			
		int menu = sc.nextInt();sc.nextLine();
		
		switch (menu) {
		case 1:
			System.out.println("회원가입");
			System.out.print("이름 : ");
			name = sc.nextLine();
			System.out.print("아이디 : ");
			id = sc.nextLine();
			System.out.print("비밀번호 : ");
			pw = sc.nextLine();
			
			break;
		case 2:
			System.out.println("로그인");
			System.out.print("아이디 : ");
			loginId = sc.nextLine();
			System.out.print("비밀번호 : ");
			loginPw = sc.nextLine();
			
			if(loginId.equals(id) && loginPw.equals(pw)) {
				System.out.println("로그인 성공");
				loginCK = true;
			}else {
				System.out.println("회원정보 확인");
			}
			
			break;
		case 3:
			System.out.println("로그인 후 이용가능");
			break;
		case 4:
			System.out.println("로그인 후 이용가능");
			break;
		case 0:
			System.out.println("종료");
			run = false;
			break;

		default:
			break;
		}

		}else {
			
			System.out.printf("1.비밀번호 변경 2.로그아웃(%s)님 3.성적등록 4.리스트 0.종료\n",name);		
			int menu = sc.nextInt();sc.nextLine();
			
			switch (menu) {
			case 1:
				System.out.print("변경할 비밀번호 : ");
				pw = sc.nextLine();
				System.out.println("비밀번호 변경완료");
				break;
			case 2:
				System.out.println("로그아웃");
				loginCK = false;
				break;
			case 3:
				System.out.println("성적등록");
				System.out.print("이름 : ");
				listName = sc.nextLine();
				System.out.print("국어 : ");
				kor = sc.nextInt();
				System.out.print("영어 : ");
				eng = sc.nextInt();
				System.out.print("수학 : ");
				math = sc.nextInt();
				
				total = kor + eng + math;
				avg = total/3;
				
				list += listName + "\t" + kor + "\t" + eng + "\t" + math + "\t" + total + "\t" + String.format("%.2f", avg) + "\n";
				
				
				break;
			case 4:
				System.out.println("리스트");
				System.out.println("이름\t국어\t영어\t수학\t총합\t평균");
				System.out.println(list);
				break;
			case 0:
				System.out.println("종료");
				run = false;
				break;

			default:
				break;
			}
		}
		}
	}

}
