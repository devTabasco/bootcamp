package front;

import java.util.Scanner;

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
		int selectMenu;

		Scanner sc = new Scanner(System.in);
		this.title = makeTitle();

		String[][] menu = { 
				{ "EXIT", "프로그램을 종료합니다.~" }, // rowIndex = 0
				{ "MAIN", "연산하기", "끝내기" }, // rowIndex = 1
				{ "연산", "새로운 연산", "이어서 연산", "이전 화면" } // rowIndex = 2
				};

		this.display(title);
		this.display(this.makeSubMenu(menu[rowIndex])); // menu[1]

		while (check) {
			
			selectMenu = this.userInput(sc);
			if (this.isIntergerRange(selectMenu, 0, menu[rowIndex].length - 2)) {
				rowIndex += (selectMenu == 0) ? -1 : 1;

				if (rowIndex == 0) {
					this.display(title);
					this.display(this.makeSubMenu(menu[rowIndex]));
					check = false;
				} else if(rowIndex == 3) {
					
					//연산하기 페이지 넘어가기
					this.display("메롱");
					check = false;
				}else {
				
					//계속 진행
					this.display(title);
					this.display(this.makeSubMenu(menu[rowIndex]));
				}	
			}else {

				//메세지 작성
				this.display(title);
				this.display(this.makeMessage("번호를 다시 선택해주세요."));
				this.display(this.makeSubMenu(menu[rowIndex]));
			}

		}

		sc.close();
	}

	// rowIndex == 1
	// {"MAIN","연산하기","끝내기"}

	public int userInput(Scanner sc) {
		return sc.nextInt();
	}

	private boolean isInteger(String value) {
		boolean isResult = true;
		try {
			Integer.parseInt(value);
		} catch (Exception e) {
			isResult = false;
			// TODO: handle exception
		}

		return isResult;
	}

	private int convertToInteger(String value) {
		return Integer.parseInt(value);
	}

	private boolean isIntergerRange(int value, int starting, int last) {
		return (value >= starting && value <= last) ? true : false;
	}

	public String makeTitle() {
		StringBuffer title = new StringBuffer();
		title.append("****************************************************\n\n");
		title.append("\tJS Framework Calculator v1.0\n");
		title.append("\t\t\tDesigned by ...\n\n");
		title.append("****************************************************\n");
		return title.toString();
	}

	public String makeMessage(String str) {
		StringBuffer message = new StringBuffer();
		message.append("[");
		message.append(str);
		message.append("]\n\n");
		return message.toString();
	}

	public String makeSubMenu(String[] menu) {
		StringBuffer subMenu = new StringBuffer();

		subMenu.append("[");
		subMenu.append(menu[0]);
		subMenu.append("]_________________________________\n\n");

		if (menu.length <= 2) {
			subMenu.append(menu[menu.length - 1] + "\n");
			subMenu.append("___________________________________________");
			check = false;
		} else {
			for (int colIdx = 1; colIdx < menu.length; colIdx++) {
				if (colIdx == menu.length - 1) {
					subMenu.append("\t0. " + menu[colIdx] + "\n");
					subMenu.append("_________________________________ select : ");
				} else {
					subMenu.append("\t" + colIdx + ". " + menu[colIdx]);
				}
			}
		}

		return subMenu.toString();
	}

	public void display(String text) {
		System.out.print(text);
	}

	public void display(String[] text) {
		for (int idx = 0; idx < text.length; idx++) {
			System.out.print((idx + 1) + ". " + text[idx] + "\t");
		}
	}

}