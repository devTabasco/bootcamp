package client;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Scanner;

import server.ServerController;
import server.TaskManager;

public class UserApp_real {

	public UserApp_real() {
		frontController();
	}

	private void frontController() {
		Scanner sc = new Scanner(System.in);
		String mainTitle = this.mainTitle(this.getToday(true));
		String mainMenu = this.getMainMenu();
		String[] accessInfo = new String[2];
		boolean isLoop = true;
		boolean accessResult;
		ServerController ctl = new ServerController();
		TaskManagement taskManagement = null;
		String[] itemName = { "id", "pw" };
		String message = null;

		while (isLoop) {

			for (int idx = 0; idx < accessInfo.length; idx++) {
				this.display(mainTitle);
				this.display(this.getAccessLayer(true, accessInfo[0]));
				accessInfo[idx] = this.userInput(sc);
			}
			this.display(this.getAccessLayer(false, null)); // print connecting...
//			connecting();

			/* 서버에 로그인 정보 전달 */
			// serviceCode=1&id=changyong&password=1234
			accessResult = ctl.controller(this.makeClientData("1", itemName, accessInfo)).equals("1") ? true : false; // "1"
																														// or
																														// "0";

			/* 서버로부터 받은 로그인 결과에 따른 화면 출력 */
			this.display(this.accessResult(accessResult));
			if (!accessResult) {
				/* 로그인 실패 */
				// n 누르면 종료
				if (this.userInput(sc).toUpperCase().equals("N")) {
					isLoop = false;
				} else { // n이 아닌 다른 문자 누르면 로그인정보 리셋
					accessInfo[0] = null;
					accessInfo[1] = null;
				}
			} else {
				/* 로그인 성공 */
				accessInfo[1] = null;
				while (isLoop) {
					String menuSelection = new String();
					while (true) {
						this.display(mainTitle);
						this.display(mainMenu);
						this.display(message != null ? "\n[Message : " + message + " ]\n" : "");

						menuSelection = this.userInput(sc);
						/* 0~4 범위의 값이 아닌 경우 재입력 요구 */
						if (this.isInteger(menuSelection)) {
							if (this.isIntegerRange(Integer.parseInt(menuSelection), 0, 4)) {
								break;
							} else {
								message = "메뉴는 0~4 범위내로 선택해주세요";
							}
						} else {
							message = "메뉴는 숫자로 입력해주세요";
						}
					}

//					}

					/* 0번 선택시 서버에 로그아웃 통보 후 프로그램 종료 */
					if (menuSelection.toUpperCase().equals("0")) {
						ctl.controller(this.makeClientData("-1", itemName, accessInfo)); // 로그아웃
						isLoop = false;
					} else {

						if (menuSelection.equals("1")) {
							taskManagement = new TaskManagement();
							String[] userInput = new String[3];
							String[] selectMonth = new String[3];
							int addMonth = 0;

							int step = 0;
//							while (true) {
								// data 유형 선택 화면

								/* TaskManagement Class Call */
								/* MakeCalendar Class Call */


								// Start Date
								while (step <= 2) {
									this.display(taskManagement.taskController(11, accessInfo[0], addMonth).toString());
									if (userInput[step] == null) {
										this.printSelectMenu(step);
										userInput[step] = this.userInput(sc); // 사용자입력
										selectMonth[step] = (LocalDate.now().plusMonths(addMonth).getYear() + "") + 
												((LocalDate.now().plusMonths(addMonth).getMonthValue()<10)?"0"+(LocalDate.now().plusMonths(addMonth).getMonthValue()):(LocalDate.now().plusMonths(addMonth).getMonthValue()) + "");
										
										if (this.isBreak(userInput[step]))
											break;
										if (this.isReStart(userInput[step])) {
											if (this.isMonthNext(userInput[step])) {
												addMonth++;
											} else {
												addMonth--;
											}
											userInput[step] = null;
											continue;
										}
										
										//사용자 입력 오류 거르기(22.11.01 오전추가)
										if(this.isInteger(userInput[step])) {
											if(!this.isIntegerRange(this.convertToInteger(userInput[step]), 1, this.getLengthOfMonth(addMonth))) {
												this.display("\n[Message : 해당 월의 날짜를 입력해주세요.  ]\n");
												userInput[step] = null;
												continue;
											}
										}else {
											if(step==2 && userInput[2].equals("T")) {
												step++;
												break;
											}
											
											userInput[step] = null;
											this.display("\n[Message : 숫자, P, N 중에 입력해주세요.  ]\n");
											continue;
										}
										
										step++;
									}
								}

								// 입력 숫자 확인(이번달 안에 있는 건지)
//								System.out.println("Step 2 호출");
								//리스트 가져오기
								this.display(taskManagement.taskController(this.makeClientData(userInput,selectMonth)).toString());
								

								// Q누르면 빠져나가기
								// P누르면 이전달 출력
								// N누르면 다음달 출력
								// 숫자 입력하면 그대로 진행
//							} true while...

						} else {

						}
					}

				}
			}
		}

		this.display("\n\n  x-x-x-x-x-x-x-x-x-x- 프로그램을 종료합니다 -x-x-x-x-x-x-x-x-x-x");
		sc.close();
	}
	
	private String makeClientData(String[] userInput,String[] selectMonth) {
		//serviceCode=12&accessCode=changyong&startDate=12&endDate=12&status=0&isEnable=0&isAll=1
		
		for(int i = 0;i<userInput.length;i++) {
			if(userInput[i].length() == 1) {
				userInput[i] = "0"+userInput[i];
			}
			
		}
		
		return "serviceCode=12&accessCode=changyong&startDate=" + selectMonth[0] + userInput[0] + "&endDate=" + selectMonth[1] + userInput[1] 
				+ "&status=1&isEnable=1&isAll=1";
//				+ userInput[2]; //추후 유형 추가
	}
	
	private void printSelectMenu(int step) {
		if(step == 0) {
			System.out.print("\t+++++++++++++++++++++++++++++++++++++ Start Date : ");
		}else if(step == 1) {
			System.out.print("\t+++++++++++++++++++++++++++++++++++++ End Date : ");
		}else {
			System.out.print("\t+++++++++++++++++++++++++++++++++++++ 유형 선택 : ");
		}
	}

	private boolean isMonthNext(String str) {
		return str.toUpperCase().equals("N") ? true : false;

	}

	// 입력값에 따라 while-loop안에 남을지 체크
	private boolean isBreak(String str) {
		return str.toUpperCase().equals("Q") ? true : false;
	}

	// while문 다시 실행 여부
	private boolean isReStart(String str) {
		return (str.toUpperCase().equals("P") || str.toUpperCase().equals("N")) ? true : false;
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

	// makeClinetData
	private String makeClientData(String serviceCode, String[] item, String[] userData) {
		StringBuffer clientData = new StringBuffer();
		clientData.append("serviceCode=" + serviceCode);
		// accessInfo에 로그아웃시에는 id만 추가되도록
		for (int i = 0; i < userData.length; i++) {
			if (userData[i] != null) { // if i = 1 >> serviceCode=-1&id=changyong
				clientData.append("&");
				clientData.append(item[i] + "=" + userData[i]);
			}
		}
		return clientData.toString(); // serviceCode=1&id=changyong&password=1234
	}

	private String mainTitle(String today) {
		StringBuffer title = new StringBuffer();
		title.append("\n------------------------------------------------------\n\n");
		title.append("\t[현우네 To-do List]\n\n");
		title.append("\t\t\t\t");
		title.append(today + "\n");
		title.append("\t\t\t\tdesigned by Changyong\n\n");
		title.append("------------------------------------------------------\n");
		return title.toString();
	}

	private String getAccessLayer(boolean isItem, String accessCode) {
		StringBuffer accessLayer = new StringBuffer();

		if (isItem) {
			accessLayer.append("\n");
			accessLayer.append("     ----------------------------------------------\n");
			accessLayer.append("     |        AccessCode          SecretCode\t  |\n");
			accessLayer.append("      --------------------------------------------\n");
			accessLayer.append("     |         " + ((accessCode != null) ? accessCode + "\t\t" : ""));
		} // else {
//			accessLayer.append("     -------------------------------- Connecting...\n");
//		}
		return accessLayer.toString();
	}

	private String accessResult(boolean isAccess) {
		StringBuffer accessResult = new StringBuffer();

		accessResult.append("\n     >>>>>>>>>>>>>>>>>>>>>>>>> ");
		if (isAccess) {
			accessResult.append("Successful Connection\n");
			accessResult.append("     Move after 2 sceonds...\n");
		} else {
			accessResult.append("Connection Failed\n");
			accessResult.append("     _______________________________ Retry(y/n) ? ");
		}

		return accessResult.toString();
	}

	// 메인 메뉴 출력
	private String getMainMenu() {
		StringBuffer mainPage = new StringBuffer();

		mainPage.append("\n");
		mainPage.append("     [ MENU SELECTION ] __________________________________\n\n");
		mainPage.append("       1. TASK LIST		2. TASK REGISTRATION\n");
		mainPage.append("       3. MODIFY TASK		4. TASK STATS\n");
		mainPage.append("       0. DISCONNECT    \n");
		mainPage.append("     ________________________________________________ : ");

		return mainPage.toString();
	}

	private void connecting() {
		System.out.print("     connecting");
		for (int i = 0; i < 13; i++) {
			System.out.print("...");

			try {
				Thread.sleep(390);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
	}

	/* 날짜시간 출력 : LocalDateTime Class + DateTimeFormatter Class */
	private String getToday(boolean isDate) {
		String pattern = (isDate) ? "yyyy. MM. dd." : "yyyy-MM-dd HH:mm:ss";
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern(pattern));
	}

	/* 사용자 입력 */
	private String userInput(Scanner scanner) {
		return scanner.next();
	}

	/* 화면 출력 */
	private void display(String text) {
		System.out.print(text);
	}
	
	/* 선택한 달의 일수 구하기 */
	private int getLengthOfMonth(int addMonth) {
		return LocalDate.now().plusMonths(addMonth).lengthOfMonth();
	}

}