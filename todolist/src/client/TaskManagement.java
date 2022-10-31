package client;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import server.ServerController;

public class TaskManagement {

	public TaskManagement() {

	}

	public Object taskController(int selection, String accessCode, int addMonth) {
		Object result = null;
		switch (selection) {
		case 11:
			result = this.makeTaskCalendarCtl(accessCode, addMonth);
			break;
		case 12:
			this.getTaskListCtl(accessCode);
			break;
//		case 2:
//			this.TaskRegistrationCtl(accessCode);
//			break;
//		case 3:
//			this.setModifyTaskCtl(accessCode);
//			break;
//		case 4:
//			this.getTaskStatCtl(accessCode);
//			break;
		}
		
		return result;
	}

	/* 특정 달의 Task Calendar 생성하기 */
	private Object makeTaskCalendarCtl(String accessCode, int addMonth) {
		// getTaskData
		ServerController serverController = new ServerController();
		String pattern = "yyyyMM";
		LocalDate today = LocalDate.now().plusMonths(addMonth);
		String[] taskDays = this.getTaskDays(serverController.controller("serviceCode=9&accessCode=" + accessCode
				+ "&date=" + today.format(DateTimeFormatter.ofPattern(pattern))));

//		System.out.println(serverController.controller("serviceCode=9&accessCode=" + accessCode + "&date="
//				+ LocalDateTime.now().format(DateTimeFormatter.ofPattern(pattern))));

		return this.makeCalendar(taskDays, today);
	}

	/* 등록된 모든 할일 리스트 가져오기 */
	private void getTaskListCtl(String accessCode) {

	}

	/* 할일 등록 하기 */
	private void TaskRegistrationCtl(String accessCode) {

	}

	/* 등록된 할일 수정하기 */
	private void setModifyTaskCtl(String accessCode) {

	}

	/* 할일에 대한 통계 만들기 */
	private void getTaskStatCtl(String accessCode) {

	}

	/* 특정 달의 할일이 등록되어있는 날짜가져오기 */
	private String[] getTaskDays(String str) {
		String[] taskDays = null;
		taskDays = str.split(":");

		return taskDays;
	}

	/* 특정 달의 할일이 등록되어있는 날짜를 특정 달의 달력에 표시하기 */
	private String makeCalendar(String[] days, LocalDate today) {
		StringBuffer calendar = new StringBuffer();
		int firstCheck = 1;
		int dayOfWeek = LocalDate.of(today.getYear(), today.getMonthValue(), 1).getDayOfWeek().getValue();
//		int dayOfWeek = LocalDate.of(2022, 12, 1).getDayOfWeek().getValue();
		int lastDay = today.lengthOfMonth();
		String pattern = "yyyy. MM";

		dayOfWeek = (dayOfWeek == 7) ? 1 : dayOfWeek + 1;

		calendar.append("\n\t+++++++++++ Previous  [ " + today.format(DateTimeFormatter.ofPattern(pattern))
				+ " ]  Next +++++++++++\n");
		calendar.append("\tSUN\tMON\tTUE\tWED\tTHU\tFRI\tSAT\n");
		
		for (int dayIdx = 1; dayIdx <= lastDay; dayIdx++) {
//			calendar.append(dayOfWeek % 7 == 1 ? " " : "");

				if (firstCheck == 1) {
					for (int i = 0; i < dayOfWeek-1; i++) {
						calendar.append("\t");
					}
				} 
				calendar.append("\t");
				calendar.append((dayIdx < 10 ? " " : "") + dayIdx);
				if(days[0] != "") {
					for(int i = 0;i<days.length;i++) {
						if(dayIdx == Integer.parseInt(days[i])) {
							calendar.append("+");
						}
						
					}
					
				}
			calendar.append(dayOfWeek % 7 == 0 ? "\n" : "");

			if (firstCheck == lastDay) {
				calendar.append("\n");
			}

			dayOfWeek++;
			firstCheck++;

		}

//		calendar.append("\t+++++++++++++++++++++++++++++++++++++ Start Date : ");

		return calendar.toString();
	}
}
