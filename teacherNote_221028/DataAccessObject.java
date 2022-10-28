package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import server.beans.AccessHistoryBean;
import server.beans.MemberBean;
import server.beans.ToDoBean;

/* Data File과의 통신 */
public class DataAccessObject {
	String[] fileInfo = {"D:\\JSFramework\\planner\\src\\database\\MEMBERS.txt", 
			"D:\\JSFramework\\planner\\src\\database\\ACCESSHISTORY.txt",
			"D:\\JSFramework\\planner\\src\\database\\TODO.txt"};
	public DataAccessObject() {
		
	}
	
	/* 회원정보 수집 */
	public ArrayList<MemberBean> readDatabase(int fileIdx) {
		String line;
		ArrayList<MemberBean> memberList = null;
		MemberBean member;
		BufferedReader buffer = null;
		
		
		try {
			buffer = new BufferedReader(new FileReader(
							new File(fileInfo[fileIdx])));
			memberList = new ArrayList<MemberBean>();
			 
			while((line = buffer.readLine())!= null) {
				String[] record = line.split(",");
				member = new MemberBean();
				member.setAccessCode(record[0]);
				member.setSecretCode(record[1]);
				member.setUserName(record[2]);
				member.setPhoneNumber(record[3]);
				member.setActivation(Integer.parseInt(record[4]));
				memberList.add(member);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			memberList = null;
			System.out.println("파일로부터 데이터를 가져올 수 없습니다.");
			e.printStackTrace();
		}finally {
			try {
				buffer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		return memberList;
	}
	
	/* 접속기록 작성 */
	public boolean writeAccessHistory(AccessHistoryBean accessInfo) {
		boolean result = false;
		BufferedWriter writer = null;

		try {
			writer = new BufferedWriter(new FileWriter(new File(this.fileInfo[accessInfo.getFileIdx()]), true));
			writer.write(accessInfo.getAccessCode());
			writer.write(",");
			writer.write(accessInfo.getAccessDate());
			writer.write(",");
			writer.write(accessInfo.getAccessType()+"");
			writer.newLine();
			writer.flush();
			result = true;
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {writer.close();} catch (IOException e) { e.printStackTrace();}
		}	
		return result;
	}
	
	/* TODO List 읽어오기 */
	public ArrayList<ToDoBean> getToDoList(ToDoBean searchInfo) {
		ArrayList<ToDoBean> dayList = null;
		ToDoBean toDo = null;
		String line;
		BufferedReader buffer = null;
		int date, recordCount=1;
		int[] dateRange = new int[2];
		
		LocalDate userDate = LocalDate.of(Integer.parseInt(searchInfo.getStartDate().substring(0, 4)), 
				Integer.parseInt(searchInfo.getStartDate().substring(4)), 1);
		
		try {
			buffer = new BufferedReader(new FileReader(new File(fileInfo[searchInfo.getFileIdx()])));
			while((line=buffer.readLine()) != null) {
				if(recordCount == 1) dayList = new ArrayList<ToDoBean>();
				
				String[] record = line.split(",");
				date = Integer.parseInt(searchInfo.getStartDate());
				dateRange[0] = Integer.parseInt(record[1].substring(0, 8));
				dateRange[1] = Integer.parseInt(record[2].substring(0, 8));
								
				if(date > dateRange[0]/100) dateRange[0] = Integer.parseInt(date + "01");
				if(date < dateRange[1]/100) {
					dateRange[1] = Integer.parseInt(date + "" + userDate.lengthOfMonth());
				}
				
				for(int idx=dateRange[0]; idx<=dateRange[1]; idx++) {
					if(recordCount != 1) {
						if(this.duplicateCheck(dayList, idx+"")) {
							continue;
						}
					}
					toDo = new ToDoBean();
					toDo.setStartDate(idx+"");
					dayList.add(toDo);
				}
				
				recordCount++;
			}
			buffer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if (buffer != null) buffer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return dayList;
	}
	
	private boolean duplicateCheck(ArrayList<ToDoBean> dayList, String compareValue) {
		boolean result = false;
		for(int listIdx=0; listIdx<dayList.size(); listIdx++) {
			if(compareValue.equals(dayList.get(listIdx).getStartDate())) {
				result = true;
				break;
			}
		}
		return result;
	}
}
