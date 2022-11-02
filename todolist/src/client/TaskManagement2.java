package client;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import server.ServerController;

public class TaskManagement2 {
	
	private ServerController server;
	
	public TaskManagement2() {
		server = new ServerController();
	}

	public Object taskController(int selection, String accessCode, int month) {
		Object result = null;
		switch(selection) {
		case 11:
			result = this.makeTaskCalendarCtl(accessCode, month);
			break;
		}
		
		return result;
	}
	
	public Object taskController(String clientData) {
		Object result = null;
		switch(clientData.split("&")[0].split("=")[1]) {
		case "12":
			result = this.getTaskListCtl(clientData);
			break;
		}
		return result;
	}

	/* 특정 달의 Task Calendar 생성하기 */
	private Object makeTaskCalendarCtl(String accessCode, int month) {
				
		LocalDate today = LocalDate.now().plusMonths(month);
				
		int[] taskDays = this.getTaskDays(this.server.controller("serviceCode=9&accessCode="+ accessCode + 
						 "&date=" + today.format(DateTimeFormatter.ofPattern("yyyyMM"))));

		return this.makeCalendar(taskDays, today);
		
	}
	
	/* 등록된 모든 할일 리스트 가져오기 */
	private Object getTaskListCtl(String clientData) {
		return this.makeTodoList(this.server.controller(clientData).split(":"));
	}
	
	private String makeTodoList(String[] record) {
		StringBuffer buffer = new StringBuffer();
		String temp;
		/*  0--> 20221012130000,20221012130000,줄넘기 100회,C,A,다음엔 꼭…
            1--> 20221029160000,20221029160000,댕댕이 산책,B,A,NONE*/
		for(int idx=0; idx<record.length ; idx++) {
			if(idx != record.length-1) {
				for(int subIdx=idx+1; subIdx<record.length ; subIdx++) {
					if(Integer.parseInt(record[idx].substring(0, 8)) > Integer.parseInt(record[subIdx].substring(0, 8))) {
						temp = record[idx];
						record[idx] = record[subIdx];
						record[subIdx] = temp;
					}
				}
			}
		}
		String[][] toDoList = new String[record.length][];
		for(int idx=0; idx<record.length ; idx++) {
			toDoList[idx] = record[idx].split(",");
		}
		
		
		String now;
		int itemCount = 0, beginIdx = 0;
		while(true) {
			now = toDoList[itemCount][0].substring(0, 8);
			itemCount = this.itemCount(toDoList, now);
			buffer.append("   [ " + now + " ]");
			buffer.append("  Total " + itemCount + " Items\n");
			buffer.append("   ───────────────────────────────────────────────────\n");
			buffer.append("     ITEM\n");
			buffer.append("     └─   Start Date	End Date	Process	Enable\n");
			buffer.append("   ───────────────────────────────────────────────────\n");
			for(int itemIdx=beginIdx; itemIdx<(beginIdx+itemCount); itemIdx++) {

			}
			if((beginIdx+itemCount) == toDoList.length) break;
			beginIdx += itemCount;
		}
		return toDoList.toString();
	}
	
	/* 특정일의 할일 건수 구하기 */
	private int itemCount(String[][] list, String compareValue) {
		int itemCount = 0;
		for(int idx=0; idx<list.length; idx++) {
			if(compareValue.equals(list[idx][0].substring(0, 8))) {
				itemCount++;
			}else {
				break;
			}
		}
		return itemCount;
	}
	/* 할일 등록 하기 */
	private Object TaskRegistrationCtl(String accessCode) {
		return null;
	}
	/* 등록된 할일 수정하기 */
	private Object setModifyTaskCtl(String accessCode) {
		return null;
	}
	/* 할일에 대한 통계 만들기 */
	private Object getTaskStatCtl(String accessCode) {
		return null;
	}
	
	/* 서버로부터 전달받은 문자열을 할일이 등록되어있는 날짜로 분리하기 */
	private int[] getTaskDays(String serverData) {
		int[] taskDays = null;
		if(!serverData.equals("")) {
			String[] splitData = serverData.split(":");
			taskDays = new int[splitData.length];

			for(int idx=0; idx<taskDays.length; idx++) {
				taskDays[idx] = Integer.parseInt(splitData[idx]);
			}
		}
		return taskDays;
	}
	
	/* 특정 달의 할일이 등록되어있는 날짜를 특정 달의 달력에 표시하기 */
	private String makeCalendar(int[] taskDays, LocalDate today) {
		StringBuffer calendar = new StringBuffer();
		int dayOfWeek = LocalDate.of(today.getYear(), today.getMonthValue(), 1).getDayOfWeek().getValue();		
		int lastDay = today.lengthOfMonth();
		boolean isTask = false;
		
		dayOfWeek = (dayOfWeek==7)? 1:dayOfWeek+1;
		
		calendar.append("\n");
		calendar.append("    +++++++++++ Previous  [ " + today.format(DateTimeFormatter.ofPattern("yyyy. MM.")) + " ]  Next +++++++++++\n");
		calendar.append("        SUN    MON    TUE    WED    THU    FRI    SAT\n");
		calendar.append("      ");
		for(int dayIdx=1-(dayOfWeek-1); dayIdx<=lastDay; dayIdx++) {
			if(dayIdx<1) {
				calendar.append("       ");
			}else {
				calendar.append(dayIdx<10? "   " + dayIdx : "  " + dayIdx);
				if(taskDays != null) {
					for(int taskDayIdx=0; taskDayIdx<taskDays.length; taskDayIdx++) {
						if(dayIdx == taskDays[taskDayIdx]) {
							isTask = true;
							break;
						}
					}
				}
				calendar.append(isTask?"+  ": "   ");
				isTask = false;
			}
			calendar.append((dayIdx+(dayOfWeek-1))%7==0? "\n      " : "");
			calendar.append(dayIdx==lastDay? "\n": "");
		}
		
		return calendar.toString();
	}
}
