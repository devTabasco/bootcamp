package server;

import java.util.ArrayList;

import server.beans.AccessHistoryBean;
import server.beans.MemberBean;
import server.beans.ToDoBean;

public class TaskManager {
	
	public TaskManager() {
		
	}
	
	/* 특정 계정의 특정 월의 할일이 등록되어 있는 날짜 리스트 가져오기*/
	public String getTodoDateCtl(String clientData) {
		DataAccessObject dao = new DataAccessObject();
		ArrayList<ToDoBean> toDoList;
		// 1. clientData : serviceCode=9&accessCode=hoonzzang&date=202210 --> Bean Data
		// 2. todo --> Dao.getToDoList --> ArrayList<ToDoBean>
		ToDoBean todo = ((ToDoBean)this.setBean(clientData));
		todo.setFileIdx(2);
		return this.convertServerData(dao.getToDoList(todo)); 	
	}
	
	private String convertServerData(ArrayList<ToDoBean> list) {
		StringBuffer serverData = new StringBuffer();
		/* 1:10:15:16:20:  --> 1:10:15:16:20 */
		for(ToDoBean todo : list) {
			serverData.append(todo.getStartDate().substring(6, 8));
			serverData.append(":");
		}
		
		/* 마지막으로 추가된 항목 삭제 */
		serverData.deleteCharAt(serverData.length()-1);
		
		return serverData.toString();
	}
	
	private Object setBean(String clientData) {
		Object object = null;
		String[] splitData = clientData.split("&");
		switch(splitData[0].split("=")[1]) {
		case "9":
			/* serviceCode=9&accessCode=hoonzzang&date=202210  */
			object = new ToDoBean();
			((ToDoBean)object).setAccessCode(splitData[1].split("=")[1]);
			((ToDoBean)object).setStartDate(splitData[2].split("=")[1]);
			break;
		}
				
		return object;
	} 
}
