//package front;
//
//import java.util.Scanner;
//import back.BackEnd;
//
//public class FrontEnd {
//
//	public FrontEnd(int recordIdx) {
//		this.controller(recordIdx);
//	}
//
//	BackEnd backEnd = new BackEnd();
//
//	public void controller(int recordIndex) {
//		Scanner scanner = new Scanner(System.in);
//		String title = this.makeTitle();
//		String[][] menu = { { "EXIT", "프로그램을 종료합니다.~" }, { "메인", "연산하기", "끝내기" },
//				{ "연산", "새로운 연산", "이어서 연산", "이전화면" } };
//		String[] operMenu = { "숫자를 입력해주세요", "연산자를 입력해주세요", "숫자를 입력해주세요", "연산결과" };
//		int[] data = new int[4];
//
//		int operMenuIndex = 0;
//		String userData = "";
//		String message = new String();
//		int selectMenu;
//		boolean loopCheck = true;
//		String statement = "";
//		long result = 0L;
//		boolean check = true;
//		boolean check2 = true;
////		boolean operCheck = false;
//
//		while (true) {
//			if (recordIndex < 3)
//				this.display(title);
//			if (message != null)
//				this.display(message);
//			if (recordIndex < 3)
//				this.display(this.makeSubMenu(menu[recordIndex]));
//			if (!loopCheck)
//				break;
//
//			if (operMenuIndex > 0) {// 초기
//				operMenuIndex = 0;
//				recordIndex = 1;
//				statement = "";
//			}
//
//			if (recordIndex != 3)
//				userData = this.userInput(scanner);
//
//			if (this.isInteger(userData)) {
//				selectMenu = this.convertToInteger(userData);
//
//				if (recordIndex <= 2) {
//					if (this.isIntegerRange(selectMenu, 0, menu[recordIndex].length - 2)) {
//						message = null;
//						recordIndex += (selectMenu == 0) ? -1 : 1;
//						if (recordIndex == 0)
//							loopCheck = false;
//
//					} else {
//						message = "[ 0~" + (menu[recordIndex].length - 2) + " 범위내 숫자를 입력해주세요]\n";
//					}
//				} else {
//					// 연산 서브메뉴 만들기
//					// 숫자를 입력해주세요, 연산자를 입력해주세요, 숫자를 입력해주세요, 연산결과
////					boolean check = true;
//
//					while (check) {
//						check = true;
//
//						if (operMenuIndex == 1) {
//							this.display(title);
//							this.display(makeOperMenu(operMenu[operMenuIndex]));
//							if (operMenuIndex > 0)
//								this.display(statement);
//							this.display("\n[선택 : 1. 더하기  2. 빼기   3. 곱하기   4. 나누기] : ");
//						} else {
//							this.display(title);
//							this.display(makeOperMenu(operMenu[operMenuIndex]));
//							if (operMenuIndex > 0)
//								this.display(statement);
//						}
//
//						if (operMenuIndex == 3) {
//							recordIndex = 2;
//							statement = "";
//
//							while (true) {
//								if (!check)
//									this.display(title);
//								if (message != null)
//									this.display(message);
//								this.display(this.makeSubMenu(menu[recordIndex]));
//
//								userData = this.userInput(scanner);
//
//								if (this.isInteger(userData))
//									selectMenu = this.convertToInteger(userData);
//
//								if (this.isIntegerRange(selectMenu, 0, menu[recordIndex].length - 2)) {
//
//									if (selectMenu == 1) {
////										operCheck = false;
//										check = false;
//										break;
//									} else if (selectMenu == 2) {
//										data[0] = (int) result;
//										data[1] = 0;
//										data[2] = 0;
//										data[3] = 0;
//										statement = "" + data[0];
//										operMenuIndex = 1;
////										operCheck = true;
//										this.display(title);
//
//										if (operMenuIndex == 1) {
//											this.display(makeOperMenu(operMenu[operMenuIndex]));
//											this.display(statement);
//											this.display("\n[선택 : 1. 더하기  2. 빼기   3. 곱하기   4. 나누기] : ");
//										} else {
//											this.display(makeOperMenu(operMenu[operMenuIndex]));
//											this.display(statement);
//										}
//										
//										break;
//										
//									} else if (selectMenu == 0) {
//										recordIndex = 1;
//										check = false;
//										break;
//									} else {
//										break;
//									}
//
//								} else {
//									message = "[ 0~" + (menu[recordIndex].length - 2) + " 범위내 숫자를 입력해주세요]\n";
//								}
//							}
//
//							if (!check)
//								break;
//
//						}
//
//						userData = this.userInput(scanner);
//
//						if (this.isInteger(userData))
//							data[operMenuIndex] = this.convertToInteger(userData);
//
//						if (operMenuIndex == 1) {
//							switch (data[operMenuIndex]) {
//							case 1:
//								statement = makeExpression("+", statement);
//								break;
//							case 2:
//								statement = makeExpression("-", statement);
//								break;
//							case 3:
//								statement = makeExpression("*", statement);
//								break;
//							case 4:
//								statement = makeExpression("/", statement);
//								break;
//							}
//						} else if (operMenuIndex == 2) {
//
//							switch (data[1]) {
//							case 1:
//								result = backEnd.add(data[0], data[2], '+');
//								break;
//							case 2:
//								result = backEnd.minus(data[0], data[2], '-');
//								break;
//							case 3:
//								result = backEnd.multiple(data[0], data[2], '*');
//								break;
//							case 4:
//								result = backEnd.devide(data[0], data[2], '/');
//								break;
//							}
//
//							statement = makeExpression(
//									String.valueOf(data[operMenuIndex] + " = " + String.valueOf(result) + "\n"),
//									statement);
//
//						} else {
//							statement = makeExpression(String.valueOf(data[operMenuIndex]), statement);
//						}
//
//						operMenuIndex++;
//
//					}
//				}
//
//			} else {
//				message = "[ 숫자로 입력해 주세요 ]\n";
//			}
//
//		}
//		scanner.close();
//	}
//
//	public String makeTitle() {
//		StringBuffer title = new StringBuffer();
//		title.append("****************************************************\n\n");
//		title.append("	    JS Framework Calculator  v1.0\n");
//		title.append("		           Designed By HoonZzang\n\n");
//		title.append("****************************************************\n\n");
//		return title.toString();
//	}
//
//	public String makeExpression(String data, String statement) {
//		StringBuffer expression = new StringBuffer();
//		expression.append(statement);
//		expression.append(data);
//		expression.append(" ");
//		return expression.toString();
//	}
//
//	public String makeOperMenu(String menu) {
//		StringBuffer subMenu = new StringBuffer();
//		subMenu.append("  [ " + menu + " ]");
//		subMenu.append(" _____________________________________\n");
//		return subMenu.toString();
//	}
//
//	public String makeMessage(String text) {
//		StringBuffer message = new StringBuffer();
//		message.append("[ ");
//		message.append(text);
//		message.append(" ]");
//		return message.toString();
//	}
//
//	public String makeSubMenu(String[] menu) {
//		StringBuffer subMenu = new StringBuffer();
//		subMenu.append("  [ " + menu[0] + " ]");
//		subMenu.append(" _____________________________________");
//		for (int underBar = 0; underBar <= 4 - menu[0].length(); underBar++) {
//			subMenu.append("_");
//		}
//		subMenu.append("\n\n");
//		if (menu.length <= 2) {
//			subMenu.append("    " + menu[menu.length - 1] + "  \n");
//			subMenu.append("  ________________________________________________\n");
//		} else {
//			for (int colIdx = 1; colIdx < menu.length; colIdx++) {
//				if (colIdx == menu.length - 1) {
//					subMenu.append("0. " + menu[colIdx] + "  \n");
//				} else {
//					subMenu.append("    " + colIdx + ". " + menu[colIdx] + "     ");
//				}
//			}
//			subMenu.append("  __________________________________ select : ");
//		}
//		return subMenu.toString();
//	}
//
//	/*
//	 * 사용자 입력 전용 메서드 고려사항 : 1. 숫자로 변환이 불가능한 데이터가 입력되어질 경우 해결방안 2. Scanner Class의
//	 * Life Cycle과 Performance
//	 */
//	public String userInput(Scanner scanner) {
//		return scanner.next();
//	}
//
//	/* 정수 변환여부 체크 */
//	private boolean isInteger(String value) {
//		boolean isResult = true;
//		try {
//			Integer.parseInt(value);
//		} catch (Exception e) {
//			isResult = false;// e.printStackTrace();
//		}
//		return isResult;
//	}
//
//	/* 문자 >> 정수 변환 */
//	private int convertToInteger(String value) {
//		return Integer.parseInt(value);
//	}
//
//	/* 정수의 범의 체크 */
//	private boolean isIntegerRange(int value, int starting, int last) {
//		return (value >= starting && value <= last) ? true : false;
//	}
//
//	/* 출력 전용 메서드1 */
//	public void display(String text) {
//		System.out.print(text);
//	}
//
//	/* 출력 전용 메서드2 */
//	public void display(String[] text) {
//		for (int idx = 0; idx < text.length; idx++) {
//			System.out.print((idx + 1) + ". " + text[idx] + "  ");
//		}
//	}
//
//}
