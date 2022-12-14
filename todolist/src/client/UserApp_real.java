package client;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import server.ServerController;

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

							/* status 선택 화면 */
							// 1. all condition(status = 0,1,-1 / isEnable = 1)
							// 2. preparing(status = 0, isEnable = 1)
							// 3. in progress(status=1,isEnable=1)
							// 4. done(status=-1, isEnable = 1)
							// 5. temporary deletion(isEnable = 0)

							this.display(this.getChoiceListMenu());
							menuSelection = this.userInput(sc);

							// conditions = {status, isEnable, isAll}

							/* status 선택 화면 */
							taskManagement = new TaskManagement();
							String[] userInput = new String[3];
							String[] selectMonth = new String[3];
							int addMonth = 0;

							int step = 0;

							// Start Date
							while (step <= 2) {
								if (step != 2) {
									this.display(taskManagement
											.taskController(11, accessInfo[0], addMonth, inputConditions(menuSelection))
											.toString());
								}
								if (userInput[step] == null) {
									this.printSelectMenu(step);
									if (step != 2) {
										userInput[step] = this.userInput(sc); // 사용자입력
									} else {
										userInput[step] = "T";
									}
									selectMonth[step] = (LocalDate.now().plusMonths(addMonth).getYear() + "")
											+ ((LocalDate.now().plusMonths(addMonth).getMonthValue() < 10)
													? "0" + (LocalDate.now().plusMonths(addMonth).getMonthValue())
													: (LocalDate.now().plusMonths(addMonth).getMonthValue()) + "");

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

									// 사용자 입력 오류 거르기(22.11.01 오전추가)
									if (this.isInteger(userInput[step])) {
										if (!this.isIntegerRange(this.convertToInteger(userInput[step]), 1,
												this.getLengthOfMonth(addMonth))) {
											this.display("\n[Message : 해당 월의 날짜를 입력해주세요.  ]\n");
											userInput[step] = null;
											continue;
										}
									} else {
										if (step == 2 && userInput[2].equals("T")) {
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
							// 강제로 나가라...
//							if (this.isBreak(userInput[step])) {
//								accessInfo[0] = null;
//								break;
//							}

							// 입력 숫자 확인(이번달 안에 있는 건지)
//								System.out.println("Step 2 호출");
							// 리스트 가져오기
							if (step > 2) {
								this.display(taskManagement.taskController(this.makeClientData(userInput, selectMonth,
										inputConditions(menuSelection), accessInfo[0])).toString());

								// 돌아가기 구현
								while (true) {
									menuSelection = this.userInput(sc);
									if (!menuSelection.equals("0")) {
										this.display("돌아가기를 원하시면, 0을 눌러주세요 : ");
									} else {
										break;
									}
								}

							}

						}

						if (menuSelection.equals("2")) {
							int addMonth = 0;
							// 일정 등록
							// 캘린더 띄우기(토탈기준)
							taskManagement = new TaskManagement();
							String[] inputSetData = new String[3];
							String tmp;
							int step = 0;
							while (true) {

								while (step <= 2) {
									this.display(taskManagement
											.taskController(11, accessInfo[0], addMonth, inputConditions("1"))
											.toString());
									this.display("\t+++++++++++++++++++++++++++++++++++++++++++++++++\n");
									if (step == 0) {
										this.display("\t시작일을 입력해주세요. ex) 2022/10/21 : ");
									} else if (step == 1) {
										this.display("\t마감일을 입력해주세요. ex) 2022/10/30 : ");
									} else {
										this.display("\t내용을 입력해주세요. (내용은 30자 이내입니다.) : ");
									}
									if (step != 2) {
										inputSetData[step] = this.userInput(sc);
									} else {
										sc.nextLine();
										inputSetData[step] = sc.nextLine();
									}

									if (this.isBreak(inputSetData[step]))
										break;
									if (this.isReStart(inputSetData[step])) {
										if (this.isMonthNext(inputSetData[step])) {
											addMonth++;
										} else {
											addMonth--;
										}
										inputSetData[step] = null;
										continue;
									}

									if (step != 2) {
										tmp = inputSetData[step].replace("/", "");
										inputSetData[step] = tmp;
									} else {
										tmp = "";
									}

									if (step == 0) {
										if (Integer.parseInt(this.getToday(true).replace(".", "").replace(" ",
												"")) > Integer.parseInt(tmp)) {
											this.display("\t오늘 이전 날짜는 시작일로 선택할 수 없습니다.\n");
											continue;
										}
									} else if (step == 1) {
										if (Integer.parseInt(inputSetData[0].replace("/", "")) > Integer
												.parseInt(tmp)) {
											this.display("\t마감일은 시작일 이전일 수 없습니다.\n");
											continue;
										}
									} else {
										if (inputSetData[2].length() > 30) {
											this.display("\t내용은 30자 이내로 작성 가능합니다.\n");
											continue;
										}
									}

									step++;

								}

								// 여기서 inputSetData[]를 사용해 server에 전달.
								ctl.controller(this.makeClientData("2", inputSetData, accessInfo[0]));

								this.display("\t등록이 완료되었습니다.\n");
								this.display("\t1. 새로운 일정 등록		2. 나가기\n");
								this.display("\t+++++++++++++++++++++++++++++++++++++++++++Select : ");

								while(true) {
									menuSelection = this.userInput(sc);
									if(!(menuSelection.equals("2") || menuSelection.equals("1"))) {
										this.display("\t올바른 번호를 선택해주세요.");
									}else {
										break;
									}
								}

								if (menuSelection.equals("2")) {
									break;
								} else if (menuSelection.equals("1")) {
									addMonth = 0;
									step = 0;
									inputSetData = null;
									continue;
								} 
							}

						}

						if (menuSelection.equals("3")) {
							// 일정 수정
							int addMonth = 0;
							int step = 0;
							String[] inputSetData = new String[2];
							String tmp;
							taskManagement = new TaskManagement();
							String[] modifyListData;
							String modifyOrigin;
							String modifyMenuSelection;

							while (step <= 1) {
								this.display(taskManagement
										.taskController(11, accessInfo[0], addMonth, inputConditions("1")).toString());

								this.display("\t+++++++++++++++++++++++++++++++++++++++++++++++++\n");
								if (step == 0) {
									this.display("\t시작 조회일을 입력해주세요. ex) 2022/10/21 : ");
								} else if (step == 1) {
									this.display("\t마지막 조회일을 입력해주세요. ex) 2022/10/30 : ");
								}
								inputSetData[step] = this.userInput(sc);

								if (this.isBreak(inputSetData[step]))
									break;
								if (this.isReStart(inputSetData[step])) {
									if (this.isMonthNext(inputSetData[step])) {
										addMonth++;
									} else {
										addMonth--;
									}
									inputSetData[step] = null;
									continue;
								}

								tmp = inputSetData[step].replace("/", "");
								inputSetData[step] = tmp;

								step++;

							}
							// 수정할 리스트 출력
							// 계정, 시작, 마감,
							modifyListData = taskManagement
									.taskController(this.makeClientData(inputSetData, accessInfo[0])).toString()
									.split(";");
							this.display(modifyListData[0]);

							// 수정할 리스트 선택
							menuSelection = this.userInput(sc);

							// 수정할 리스트 내역 보여주기
							while (true) {
								modifyOrigin = "serviceCode=14&" + "originData=" + accessInfo[0] + ","
										+ modifyListData[Integer.parseInt(menuSelection)];
								if (menuSelection.equals("0"))
									break;
								modifyListData = makeModifyView(modifyListData[Integer.parseInt(menuSelection)])
										.split(";");
								this.display(modifyListData[0]);

								modifyMenuSelection = this.userInput(sc);

								// 내용수정
								// 날짜수정
								// 진행상태수정
								// 삭제
								// 코멘트 남기기
								// 를 선택했을 때 해당 선택지를 파라미터로 받아 그에 맞는 뷰를 보여주고,
								// 수정된 데이터를 전달받아 데이터베이스 업데이트 후 while문을 통해 위 수정리스트 내역을 띄워주기.
								// status랑 isEnable 정보가 필요하면, makeModifyView에서 String으로 받아와 나눠서 파라미터로 넘기기.

								if (modifyMenuSelection.equals("4")) {
									// serviceCode=14&originData=changyong,202211021100,202211051000,코딩하기,1,1,null&isEnAble=
									if (modifyOrigin.split("&")[1].split("=")[1].split(",")[5].equals("1")) {
										ctl.controller(modifyOrigin + "&isEnAble=0");
									} else {
										ctl.controller(modifyOrigin + "&isEnAble=1");
									}
									break;
									// 상태 바꿔서 보내주기
								}
								if (modifyMenuSelection.equals("0"))
									break; // 그냥 break

								// 메뉴 선택에 따른 수정할 내용을 반환, 날짜의 경우 ;를 구분자로 시작일;마감일 을 받음.
								tmp = this.modifyController(modifyMenuSelection, sc, modifyListData[1],
										modifyListData[2]);

								if (modifyMenuSelection.equals("1")) {
									ctl.controller(modifyOrigin + "&contents=" + tmp);
//									display(modifyOrigin + "&contents=" + tmp);
									break;
								} else if (modifyMenuSelection.equals("2")) {
									ctl.controller(modifyOrigin + "&date=" + tmp);
//									display(modifyOrigin + "&date=" + tmp);
									break;
								} else if (modifyMenuSelection.equals("3")) {
									ctl.controller(modifyOrigin + "&status=" + tmp);
//									display(modifyOrigin + "&status=" + tmp);
									break;
								} else if (modifyMenuSelection.equals("5")) {
									ctl.controller(modifyOrigin + "&comments=" + tmp);
//									display(modifyOrigin + "&comments=" + tmp);
									break;
								}

							}
						}
					}

				}
			}
		}

		this.display("\n\n  x-x-x-x-x-x-x-x-x-x- 프로그램을 종료합니다 -x-x-x-x-x-x-x-x-x-x");
		sc.close();
	}

	private String modifyController(String menuSelection, Scanner sc, String status, String isEnAble) {
		StringBuffer response = new StringBuffer();
		String tmp;

		if (menuSelection.equals("1")) {
			this.display("수정할 내용을 입력하세요 : ");
			sc.nextLine();
			response.append(sc.nextLine());
		} else if (menuSelection.equals("2")) {
			this.display("시작 변경일을 입력해주세요. ex) 2022/10/21 : ");
			response.append(this.userInput(sc).replace("/", ""));
			response.append(",");
			this.display("마감 변경일을 입력해주세요. ex) 2022/10/30 : ");
			response.append(this.userInput(sc).replace("/", ""));
		} else if (menuSelection.equals("3")) {
			if (status.equals("진행 전")) {
				this.display("변경할 상태를 선택해주세요 : \n");
				this.display("1. 진행 중	2. 진행 완료	0. 취소");
				tmp = userInput(sc);
				if (tmp.equals("1")) {
					response.append("1");
				} else if (tmp.equals("2")) {
					response.append("-1");
				} else {
					response.append("취소");
				}
			} else if (status.equals("진행 중")) {
				this.display("변경할 상태를 선택해주세요 : \n");
				this.display("1. 진행 전	2. 진행 완료	0. 취소");
				tmp = userInput(sc);
				if (tmp.equals("1")) {
					response.append("0");
				} else if (tmp.equals("2")) {
					response.append("-1");
				} else {
					response.append("취소");
				}
			} else if (status.equals("진행 완료")) {
				this.display("변경할 상태를 선택해주세요 : \n");
				this.display("1. 진행 전	2. 진행 중	0. 취소");
				tmp = userInput(sc);
				if (tmp.equals("1")) {
					response.append("0");
				} else if (tmp.equals("2")) {
					response.append("1");
				} else {
					response.append("취소");
				}
			}
		} else if (menuSelection.equals("5")) {
			while (true) {
				this.display("Comment를 입력해주세요(30자 이내) : ");
				sc.nextLine();
				tmp = sc.nextLine();
				if (tmp.length() <= 30) {
					response.append(tmp);
					break;
				}
			}

		}

		return response.toString();
	}

	private String makeModifyView(String todoData) {
		/*
		 * ------------------------------------------------- [Task 날짜] [내용] [현재 상태] ([삭제
		 * 여부]) ------------------------------------------------- [comment]
		 */

		String[] data = todoData.split(",");

		switch (data[3]) {
		case "1":
			data[3] = "진행 중";
			break;
		case "-1":
			data[3] = "진행 완료";
			break;
		case "0":
			data[3] = "진행 전";
			break;
		}

		switch (data[4]) {
		case "1":
			data[4] = "활성";
			break;
		case "0":
			data[4] = "삭제";
			break;
		}

		if (data[3].equals("1")) {
		}

		StringBuffer modifyView = new StringBuffer();
		modifyView.append("------------------------------------------------------\n\n");
		modifyView.append("    [선택날짜 : " + data[0].substring(0, 8) + " - " + data[1].substring(0, 8) + "]\n\n");
		modifyView.append("\t\t[" + data[2] + "]\n\n");
		modifyView.append("    [현재상태 : " + data[3] + "]" + "\t\t" + "[삭제여부 : " + data[4] + "]\n\n");
		modifyView.append("------------------------------------------------------\n");
		modifyView.append("[코멘트 : " + data[5] + "]\n\n");
		modifyView.append("1. 내용 수정\n" + "2. 날짜 수정\n" + "3. 진행상태 수정\n");
		if (data[4].equals("활성")) {
			modifyView.append("4. 삭제\n");
		} else {
			modifyView.append("4. 되돌리기\n");
		}
		modifyView.append("5. comment 남기기\n" + "0. 돌아가기\n\n메뉴를 선택해주세요 : ");

		modifyView.append(";");
		modifyView.append(data[3]);
		modifyView.append(";");
		modifyView.append(data[4]);
		return modifyView.toString();
	}

	private String makeClientData(String[] inputSetData, String accessCode) {
		StringBuffer clientData = new StringBuffer();
		clientData.append("serviceCode=13");
		clientData.append("&id=" + accessCode);
		clientData.append("&startDate=" + inputSetData[0] + "0000");
		clientData.append("&endDate=" + inputSetData[1] + "0000");
		return clientData.toString();
	}

	private String inputConditions(String menuSelection) {
		// 0 -> status / 1-> isEnable / 2-> isAll
		String[] conditions = new String[3];
		if (menuSelection.equals("1")) {
			conditions[1] = "1";
			conditions[2] = "1";
		} else if (menuSelection.equals("2")) {
			conditions[0] = "0";
			conditions[1] = "1";
		} else if (menuSelection.equals("3")) {
			conditions[0] = "1";
			conditions[1] = "1";
		} else if (menuSelection.equals("4")) {
			conditions[0] = "-1";
			conditions[1] = "1";
		} else {
			conditions[1] = "0";
		}

		return "status=" + conditions[0] + "&isEnable=" + conditions[1] + "&isAll=" + conditions[2];

	}

	private String makeClientData(String[] userInput, String[] selectMonth, String inputConditions, String accessCode) {
		// serviceCode=12&accessCode=changyong&startDate=12&endDate=12&status=0&isEnable=0&isAll=1

		for (int i = 0; i < userInput.length; i++) {
			if (userInput[i].length() == 1) {
				userInput[i] = "0" + userInput[i];
			}

		}

		return "serviceCode=12&accessCode=" + accessCode + "&startDate=" + selectMonth[0] + userInput[0] + "&endDate="
				+ selectMonth[1] + userInput[1] + "&status=" + inputConditions.split("&")[0].split("=")[1]
				+ "&isEnable=" + inputConditions.split("&")[1].split("=")[1] + "&isAll="
				+ inputConditions.split("&")[2].split("=")[1];
//				+ userInput[2]; //추후 유형 추가
	}

	private void printSelectMenu(int step) {
		if (step == 0) {
			System.out.print("\t+++++++++++++++++++++++++++++++++++++ Start Date : ");
		} else if (step == 1) {
			System.out.print("\t+++++++++++++++++++++++++++++++++++++ End Date : ");
		}
//		else {
//			System.out.print("\t+++++++++++++++++++++++++++++++++++++ 유형 선택 : ");
//		}
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

	private String makeClientData(String serviceCode, String[] inputSetData, String accessCode) {
		// serviceCode=2&id=changyong&startDate=202211020000&endDate=202211020000&contents=dd
		String[] item = { "startDate", "endDate", "contents" };
		StringBuffer clientData = new StringBuffer();
		clientData.append("serviceCode=" + serviceCode);
		clientData.append("&id=" + accessCode);
		for (int i = 0; i < inputSetData.length; i++) {
			if (inputSetData[i] != null) {
				clientData.append("&");
				clientData.append(item[i] + "=" + ((i < 2) ? (inputSetData[i] + "0000") : inputSetData[i]));
			}
		}
//		System.out.println(clientData.toString());
		return clientData.toString();
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

		accessResult.append("     >>>>>>>>>>>>>>>>>>>>>>>>> ");
		if (isAccess) {
			accessResult.append("Successful Connection\n");
//			accessResult.append("     Move after 2 sceonds...\n");
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

	// 1. all condition(status = 0,1,-1 / isEnable = 1)
	// 2. preparing(status = 0, isEnable = 1)
	// 3. in progress(status=1,isEnable=1)
	// 4. done(status=-1, isEnable = 1)
	// 5. temporary deletion(isEnable = 0)

	private String getChoiceListMenu() {
		StringBuffer choiceMenu = new StringBuffer();

		choiceMenu.append("\n");
		choiceMenu.append("     [ MENU SELECTION ] __________________________________\n\n");
		choiceMenu.append("       1. All Condition		2. Preparing\n");
		choiceMenu.append("       3. In progress		4. Done\n");
		choiceMenu.append("       5. Temporary deletion\n");
		choiceMenu.append("     ________________________________________________ : ");

		return choiceMenu.toString();
	}

	private void connecting() {
		System.out.print("     connecting");
		for (int i = 0; i < 12; i++) {
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