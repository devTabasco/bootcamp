//package front;
//
//import java.util.Scanner;
//
//public class FrontEnd {
//
//	private String title;
//	private boolean check = true;
//
//	// 1. 생성자가 속해 있는 block의 Class mamber list를 메모리로 loading
//	// 2. (필요시) field initialization
//	// 3. 클래스를 로딩할 때 단 1번만 실행 할 수 있다.
//	public FrontEnd(int rowIndex) {
//		this.controller(rowIndex);
//	}
//
//	public void controller(int rowIndex) {
//		int selectMenu = 0;
//
//		Scanner sc = new Scanner(System.in);
//		this.title = makeTitle();
//
//		String[][] menu = { 
//				{ "EXIT", "프로그램을 종료합니다.~" }, // rowIndex = 0
//				{ "MAIN", "연산하기", "끝내기" }, // rowIndex = 1
//				{ "연산", "새로운 연산", "이어서 연산", "이전 화면" } // rowIndex = 2
//				};
//		
////		String message = new String();
//		this.display(title);
//		this.display(this.makeSubMenu(menu[rowIndex])); // menu[1]
//
//		while (check) {
//			
//			String input = this.userInput(sc);
//			
//			if(this.isInteger(input)) {
//				selectMenu = this.convertToInteger(input);
//			}else {
//				this.display(title);
//				this.display(this.makeMessage("번호를 다시 선택해주세요."));
//				this.display(this.makeSubMenu(menu[rowIndex]));
//			}
//			
//			if (this.isIntergerRange(selectMenu, 0, menu[rowIndex].length - 2)) {
//				rowIndex += (selectMenu == 0) ? -1 : 1;
//
//				if (rowIndex == 0) {
//					this.display(title);
//					this.display(this.makeSubMenu(menu[rowIndex]));
//					check = false;
//				} else if(rowIndex == 3) {
//					
//					//연산하기 페이지 넘어가기
//					this.display("메롱");
//					check = false;
//				}else {
//					//계속 진행
//					this.display(title);
//					this.display(this.makeSubMenu(menu[rowIndex]));
//				}	
//			}else {
//				//메세지 작성
//				
//				String message = "" + (menu[rowIndex].length-2) + "";
//				this.display(title);
//				this.display(this.makeMessage("번호를 다시 선택해주세요."));
//				this.display(this.makeSubMenu(menu[rowIndex]));
//			}
//
//		}
//
//		sc.close();
//	}
//
//	// rowIndex == 1
//	// {"MAIN","연산하기","끝내기"}
//
//	public String userInput(Scanner sc) {
//		return sc.next();
//	}
//	
//	private boolean isInteger(String value) {
//		boolean isResult = true;
//		try {
//			Integer.parseInt(value);
//		} catch (Exception e) {
//			isResult = false;
//		}
//
//		return isResult;
//	}
//
//	private int convertToInteger(String value) {
//		return Integer.parseInt(value);
//	}
//
//	private boolean isIntergerRange(int value, int starting, int last) {
//		return (value >= starting && value <= last) ? true : false;
//	}
//
//	public String makeTitle() {
//		StringBuffer title = new StringBuffer();
//		title.append("****************************************************\n\n");
//		title.append("\tJS Framework Calculator v1.0\n");
//		title.append("\t\t\tDesigned by ...\n\n");
//		title.append("****************************************************\n");
//		return title.toString();
//	}
//
//	public String makeMessage(String str) {
//		StringBuffer message = new StringBuffer();
//		message.append("[");
//		message.append(str);
//		message.append("]\n\n");
//		return message.toString();
//	}
//
//	public String makeSubMenu(String[] menu) {
//		StringBuffer subMenu = new StringBuffer();
//
//		subMenu.append("[");
//		subMenu.append(menu[0]);
//		subMenu.append("]_________________________________\n\n");
//
//		if (menu.length <= 2) {
//			subMenu.append(menu[menu.length - 1] + "\n");
//			subMenu.append("___________________________________________");
//			check = false;
//		} else {
//			for (int colIdx = 1; colIdx < menu.length; colIdx++) {
//				if (colIdx == menu.length - 1) {
//					subMenu.append("\t0. " + menu[colIdx] + "\n");
//					subMenu.append("_________________________________ select : ");
//				} else {
//					subMenu.append("\t" + colIdx + ". " + menu[colIdx]);
//				}
//			}
//		}
//
//		return subMenu.toString();
//	}
//
//	public void display(String text) {
//		System.out.print(text);
//	}
//
//	public void display(String[] text) {
//		for (int idx = 0; idx < text.length; idx++) {
//			System.out.print((idx + 1) + ". " + text[idx] + "\t");
//		}
//	}
//
//}

package front;

import java.util.Scanner;

public class FrontEnd {

	public FrontEnd(int recordIdx) {
		this.controller(recordIdx);
	}

	public void controller(int recordIndex) {
		Scanner scanner = new Scanner(System.in);
		String title = this.makeTitle();
		String[][] menu = { { "EXIT", "프로그램을 종료합니다.~" }, { "메인", "연산하기", "끝내기" },
				{ "연산", "새로운 연산", "이어서 연산", "이전화면" } };
		String[] data = new String[4];

		String userData;
		String message = new String();
		String operation = "";
		int selectMenu;
		boolean loopCheck = true;
		int promptIndex = 0;
		boolean operatorCheck = true;
		String[] prompt = { "숫자를 입력해주세요", "연산자를 선택해주세요", "숫자를 입력해주세요", "연산결과" };

		while (true) {
			if (operatorCheck)
				this.display(title);
			if (message != null)
				this.display(message);
			
			if (recordIndex >= 3) {
				this.display(title);
				this.display(this.makeOperatorMenu(prompt[promptIndex]));
			} else {
				this.display(this.makeSubMenu(menu[recordIndex]));

				if (!loopCheck)
					break;

				userData = this.userInput(scanner);

				if (this.isInteger(userData)) {
					selectMenu = this.convertToInteger(userData);
					recordIndex += (selectMenu == 0)? -1: 1;

					if (recordIndex >= 3) {
						
						while (true) {

							String num1 = scanner.next();
							data[0] = num1;
							operation = printOperation(data[0], operation);
							promptIndex++;

							///////////////////////

							this.display(title);
							this.display(this.makeOperatorMenu(prompt[promptIndex]));
							System.out.println(operation);
							System.out.print(" [선택 : 1. 더하기  2. 빼기   3. 곱하기   4. 나누기] : ");

							String operator = scanner.next();
							data[1] = operator;

							switch (data[1]) {
							case "1":
								data[1] = "+";
								break;
							case "2":
								data[1] = "-";
								break;
							case "3":
								data[1] = "*";
								break;
							case "4":
								data[1] = "/";
								break;
							default:
								break;
							}

							operation = printOperation(data[1], operation);
							promptIndex++;

							///////////////////////

							this.display(title);
							this.display(this.makeOperatorMenu(prompt[promptIndex]));
							System.out.print(operation);

							String num2 = scanner.next();
							data[2] = num2;
							operation = printOperation(data[2], operation);
							promptIndex++;

							/////////////////////

							this.display(title);
							this.display(this.makeOperatorMenu(prompt[promptIndex]));
							System.out.print(operation + "= ");
							promptIndex = 0;

							// backend 연결
							switch (data[1]) {
							case "+":
								System.out.println(Integer.parseInt(data[0]) + Integer.parseInt(data[2]));
								break;
							case "-":
								System.out.println(Integer.parseInt(data[0]) - Integer.parseInt(data[2]));
								break;
							case "*":
								System.out.println(Integer.parseInt(data[0]) * Integer.parseInt(data[2]));
								break;
							case "/":
								System.out.println(Integer.parseInt(data[0]) / Integer.parseInt(data[2]));
								break;
							default:
								break;
							}

							operatorCheck = false;
							operation = "";
							break;
						}
					} else {
						if (this.isIntegerRange(selectMenu, 0, menu[recordIndex].length - 2)) {
							message = null;

							if (recordIndex <= 2) {
								recordIndex += (selectMenu == 0) ? -1 : 1;
							} else {
								recordIndex = ((selectMenu == 0) ? 1 : 3);
							}

							if (recordIndex == 0)
								loopCheck = false;

						} else {
							message = "[ 0~" + (menu[recordIndex].length - 2) + " 범위내 숫자를 입력해주세요]";
						}
					}

				} else {
					message = "[ 숫자로 입력해 주세요 ]\n";
				}
			}

		}
		scanner.close();
	}

	public void operator(String title, String[] menu, Scanner sc) {

	}

	public String printOperation(String input, String operation) {
		StringBuffer str = new StringBuffer();
		str.append(operation);
		str.append(input);
		str.append(" ");
		return str.toString();
	}

	public String makeTitle() {
		StringBuffer title = new StringBuffer();
		title.append("****************************************************\n\n");
		title.append("	    JS Framework Calculator  v1.0\n");
		title.append("		           Designed By HoonZzang\n\n");
		title.append("****************************************************\n\n");
		return title.toString();
	}

	public String makeMessage(String text) {
		StringBuffer message = new StringBuffer();
		message.append("[ ");
		message.append(text);
		message.append(" ]");
		return message.toString();
	}

	public String makeSubMenu(String[] menu) {
		StringBuffer subMenu = new StringBuffer();
		subMenu.append("  [ " + menu[0] + " ]");
		subMenu.append(" _____________________________________");
		for (int underBar = 0; underBar <= 4 - menu[0].length(); underBar++) {
			subMenu.append("_");
		}
		subMenu.append("\n\n");
		if (menu.length <= 2) {
			subMenu.append("    " + menu[menu.length - 1] + "  \n");
			subMenu.append("  ________________________________________________\n");
		} else {
			for (int colIdx = 1; colIdx < menu.length; colIdx++) {
				if (colIdx == menu.length - 1) {
					subMenu.append("0. " + menu[colIdx] + "  \n");
				} else {
					subMenu.append("    " + colIdx + ". " + menu[colIdx] + "     ");
				}
			}
			subMenu.append("  __________________________________ select : ");
		}
		return subMenu.toString();
	}

	public String makeOperatorMenu(String prompt) {

		StringBuffer subMenu = new StringBuffer();
		subMenu.append("  [ " + prompt + " ]");
		subMenu.append(" _____________________________________\n");

		return subMenu.toString();
	}

	/*
	 * 사용자 입력 전용 메서드 고려사항 : 1. 숫자로 변환이 불가능한 데이터가 입력되어질 경우 해결방안 2. Scanner Class의
	 * Life Cycle과 Performance
	 */
	public String userInput(Scanner scanner) {
		return scanner.next();
	}

	/* 정수 변환여부 체크 */
	private boolean isInteger(String value) {
		boolean isResult = true;
		try {
			Integer.parseInt(value);
		} catch (Exception e) {
			isResult = false;// e.printStackTrace();
		}
		return isResult;
	}

	/* 문자 >> 정수 변환 */
	private int convertToInteger(String value) {
		return Integer.parseInt(value);
	}

	/* 정수의 범의 체크 */
	private boolean isIntegerRange(int value, int starting, int last) {
		return (value >= starting && value <= last) ? true : false;
	}

	/* 출력 전용 메서드1 */
	public void display(String text) {
		System.out.print(text);
	}

	/* 출력 전용 메서드2 */
	public void display(String[] text) {
		for (int idx = 0; idx < text.length; idx++) {
			System.out.print((idx + 1) + ". " + text[idx] + "  ");
		}
	}

}
