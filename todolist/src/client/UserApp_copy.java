package client;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import server.ServerController;

public class UserApp_copy {

	public UserApp_copy() {
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
		String[] itemName = { "id", "pw" };
//		String[][] menu = {
//				{ "Menu Selection", "1. Task List", "2. Task Settings", "3. Modify Task", "4. Task Stats",
//						"0. Disconnect" },
//				{ "Select List Menu", "1. all condition", "2. preparing", "3. in progress", "4. done",
//						"5. temporary deletion", "0. 돌아가기" } };
//
//		System.out.println(title);
//		System.out.println(makeSignin());
//
//		loginInfo = sc.nextLine();
//		connecting();
//		display(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Successful Connection!\n");
//
//		display(title);
//		display(this.getMainMenu());

		while (isLoop) {

			for (int idx = 0; idx < accessInfo.length; idx++) {
				this.display(mainTitle);
				this.display(this.getAccessLayer(true, accessInfo[0]));
				accessInfo[idx] = this.userInput(sc);
			}
			this.display(this.getAccessLayer(false, null)); // print connecting...
			connecting();

			/* 서버에 로그인 정보 전달 */
			ctl.controller(this.makeClientData("1", itemName, accessInfo));

			/* 서버로부터 받은 로그인 결과에 따른 화면 출력 */
			accessResult = true; // server에서 true를 받았다고 가정
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
				while (isLoop) {
					String menuSelection = new String();
					this.display(mainTitle);
					this.display(mainMenu);
					menuSelection = this.userInput(sc);

					/* 0번 선택시 서버에 로그아웃 통보 후 프로그램 종료 */
					if (menuSelection.toUpperCase().equals("0")) {
						isLoop = false;
					}
				}
			}
		}

		this.display("\n\n  x-x-x-x-x-x-x-x-x-x- 프로그램을 종료합니다 -x-x-x-x-x-x-x-x-x-x");
		sc.close();

//		System.out.println("아이디는 " + id);
//		System.out.println("비밀번호는 " + pw);

//		backEnd.makeCalendar(2022, 10);
	}

	// makeClinetData
	private String makeClientData(String serviceCode, String[] item, String[] userData) {
		StringBuffer clientData = new StringBuffer();
		clientData.append("serviceCode=" + serviceCode);
		for (int i = 0; i < userData.length; i++) {
			clientData.append("&");
			clientData.append(item[i] + "=" + userData[i]);
		}
		return clientData.toString();
	}

	// ID, PW 존재여부를 받아 text 출력
	private String loginResult(boolean loginCk) {
		if (loginCk)
			return ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Successful Connection!\n";
		else
			return ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Connection failed!\n";
	}

	private String mainTitle(String today) {
		StringBuffer title = new StringBuffer();
		title.append("------------------------------------------------------\n\n");
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
		} //else {
//			accessLayer.append("     -------------------------------- Connecting...\n");
//		}
		return accessLayer.toString();
	}

	private String accessResult(boolean isAccess) {
		StringBuffer accessResult = new StringBuffer();

		accessResult.append("\n     >>>>>>>>>>>>>>>>>>>>>>>>> ");
		if (isAccess) {
			accessResult.append("Successful Connection\n");
			accessResult.append("     Move after 2 sceonds...");
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
		for (int i = 0; i < 15; i++) {
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

}