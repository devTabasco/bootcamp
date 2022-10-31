package server;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import javax.management.StringValueExp;

import server.beans.AccessHistoryBean;
import server.beans.MemberBean;
import server.beans.TodoBean;

public class TaskManager {

	public TaskManager() {

	}

	/* 특정 계정의 특정 월의 할일이 등록되어 있는 날짜 리스트 가져오기 */
	public String getTodoDateCtl(String clientData) {
		DataAccessObject dao = new DataAccessObject();
		// 1. clientData : serviceCode=9&accessCode=hoonzzang&date=202210 --> Bean Data
		// 2. todo --> Dao.getToDoList --> ArrayList<ToDoBean>
//		System.out.println(this.convertServerData(dao.getToDoList((TodoBean) this.setBean(clientData))));
		return this.convertServerData(dao.getToDoList((TodoBean) this.setBean(clientData)));
	}

	private String convertServerData(ArrayList<TodoBean> list) {
		int count = 0;
		StringBuffer serverData = new StringBuffer();
		/* 1:10:15:16:20: --> 1:10:15:16:20 */
		for (TodoBean todo : list) {
			if(count != 0) serverData.append(":");
			serverData.append(todo.getStartDate().substring(6, 8));
			count++;
		}

		/* 마지막으로 추가된 항목 삭제 */
		if(serverData.length() != 0){
			serverData.charAt((serverData.length()-1));
		}else {
			
		}
		
		
		/* 중복값 제거 */
		// 배열 준비
		String[] arr = serverData.toString().split(":");       
		HashSet <String> hashSet = new HashSet<>(Arrays.asList(arr));         
		// HashSet을 배열로 변환        
		String[] resultArr = hashSet.toArray(new String[0]);
		StringBuffer str = new StringBuffer();
		
		for(int i=0;i<resultArr.length;i++) {
			if(i!=0) str.append(":");
			str.append(resultArr[i]);
		}
		
//		System.out.println(str.toString());

//		return serverData.toString();
		return str.toString();
	}

	private Object setBean(String clientData) {
		Object object = null;
		String[] splitData = clientData.split("&");
		switch (splitData[0].split("=")[1]) {
		case "9":
			/* serviceCode=9&accessCode=changyong&date=202210 */
			object = new TodoBean();
			((TodoBean) object).setFileIndex(2);
			((TodoBean) object).setAccessCode(splitData[1].split("=")[1]);
			((TodoBean) object).setStartDate(splitData[2].split("=")[1]);
			break;
		}

		return object;
	}
}
