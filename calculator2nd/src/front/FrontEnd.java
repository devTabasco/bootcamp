package front;

import java.util.Scanner;

import loader.Loader;

public class FrontEnd {

	private String title;
	private boolean check = true;

	// 1. 생성자가 속해 있는 block의 Class mamber list를 메모리로 loading
	// 2. (필요시) field initialization
	// 3. 클래스를 로딩할 때 단 1번만 실행 할 수 있다.
	public FrontEnd(int rowIndex) {
		this.controller(rowIndex);
		
	}

	public void controller(int rowIndex) {
		Scanner sc = new Scanner(System.in);
		this.title = makeTitle();


		String[][] menu = { { "EXIT", "프로그램을 종료합니다.~" }, 
				{ "MAIN", "연산하기", "끝내기" },
				{ "연산", "새로운 연산", "이어서 연산", "이전 화면" }
				};
		
		this.display(title);
		this.display(this.makeSubMenu(menu[rowIndex]));
		
		while(check) {
			rowIndex = userInput(sc);
			if(rowIndex == 1) {
				this.display(this.makeSubMenu(menu[rowIndex+1]));
			}else if(rowIndex == 0) {
				this.display(this.makeSubMenu(menu[rowIndex+1]));
			}
		}
		
		sc.close();
	}

	// rowIndex == 1
	// {"MAIN","연산하기","끝내기"}
	
	public int userInput(Scanner sc) {
		return sc.nextInt();
	}

	public String makeTitle() {
		StringBuffer title = new StringBuffer();
		title.append("****************************************************\n\n");
		title.append("\tJS Framework Calculator v1.0\n");
		title.append("\t\t\tDesigned by ...\n\n");
		title.append("****************************************************");
		return title.toString();
	}

	public String makeMessage(String str) {
		StringBuffer message = new StringBuffer();
		message.append("[");
		message.append(str);
		message.append("]");
		return message.toString();
	}

	public String makeSubMenu(String[] menu) {
		StringBuffer subMenu = new StringBuffer();

		subMenu.append("[");
		subMenu.append(menu[0]);
		subMenu.append("]_________________________________\n\n");
		
		if(menu.length<=2) {
			subMenu.append(menu[menu.length-1]+"\n");
			subMenu.append("___________________________________________");
			check = false;
		}else {
			for(int colIdx = 1;colIdx<menu.length;colIdx++) {
				if(colIdx == menu.length-1) {
					subMenu.append("0. "+menu[colIdx]+"\n");
					subMenu.append("_________________________________ select : ");
				}else {
					subMenu.append(colIdx + ". " + menu[colIdx] + "\t");
				}
			}
		}
		return subMenu.toString();
	}

	public void display(String text) {
		System.out.println(text);
	}

	public void display(String[] text) {
		for(int idx = 0;idx<text.length;idx++) {
			System.out.print((idx+1) + ". " + text[idx] + "\t");
		}
	}

}