package client;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import server.ServerController;

public class TaskManagement {

	public TaskManagement() {

	}

	public Object taskController(int selection, String accessCode) {
		Object result = null;
		switch(selection) {
		case 11:
			this.makeTaskCalendarCtl(result, accessCode);
			break;
		case 12:
			this.getTaskListCtl(result, accessCode);
			break;
		case 2:
			this.TaskRegistrationCtl(result, accessCode);
			break;
		case 3:
			this.setModifyTaskCtl(result, accessCode);
			break;
		case 4:
			this.getTaskStatCtl(result, accessCode);
			break;
		}
		return result;
	}

	/* 특정 달의 Task Calendar 생성하기 */
	private void makeTaskCalendarCtl(Object result, String accessCode) {
		ServerController server = new ServerController();
		String pattern = "yyyyMM";
		System.out.println(
				server.controller("serviceCode=9&accessCode="+ accessCode + 
						"&date=" + LocalDateTime.now().format(DateTimeFormatter.ofPattern(pattern))));
	}
	
	/* 등록된 모든 할일 리스트 가져오기 */
	private void getTaskListCtl(Object result, String accessCode) {
		
	}
	/* 할일 등록 하기 */
	private void TaskRegistrationCtl(Object result, String accessCode) {

	}
	/* 등록된 할일 수정하기 */
	private void setModifyTaskCtl(Object result, String accessCode) {

	}
	/* 할일에 대한 통계 만들기 */
	private void getTaskStatCtl(Object result, String accessCode) {

	}
	
	/* 특정 달의 할일이 등록되어있는 날짜가져오기 */
	private String[] getTaskDays() {
		String[] taskDays = null;
		
		return taskDays;
	}
	/* 특정 달의 할일이 등록되어있는 날짜를 특정 달의 달력에 표시하기 */
	private String makeCalendar(String[] days) {
		StringBuffer calendar = new StringBuffer();
		
		return calendar.toString();
	}
}
