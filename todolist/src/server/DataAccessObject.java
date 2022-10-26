package server;

import java.io.*;
import java.util.ArrayList;

import server.beans.AccessHistoryBean;
import server.beans.MemberBean;

//To access database
public class DataAccessObject {
	private String[] fileInfo = { "C:\\java\\data\\todolist\\src\\database\\MEMBERS.txt",
			"C:\\java\\data\\todolist\\src\\database\\ACCESSHISTORY.txt" };

	public DataAccessObject() {

	}

	// member파일 전달
	public ArrayList<MemberBean> readDatabase(int fileIndex) {
		MemberBean memberBean;
		ArrayList<MemberBean> memberList = null;
		BufferedReader buffer = null;

		try {
			// csv 데이터 파일
			buffer = new BufferedReader(new FileReader(new File(fileInfo[fileIndex])));
			String line = null;
			memberList = new ArrayList<MemberBean>();

			while ((line = buffer.readLine()) != null) {
				// changyong,1234,창용,01012345678,1
				// split
				String[] tmp = line.split(",");
				memberBean = new MemberBean();

				// bean가져와서 데이터 넣기
				memberBean.setAccessCode(tmp[0]);
				memberBean.setSecretCode(tmp[1]);
				memberBean.setName(tmp[2]);
				memberBean.setPhoneNumber(tmp[3]);
				memberBean.setActivation(Integer.parseInt(tmp[4]));

				// ArrayList에 new MemberBean()의 주소를 저장
				memberList.add(memberBean);

			}
			// heap에 참조선이 연결된 부분은 예외처리 시 null로 초기화시켜 heap데이터를 제거해주어야 함.
		} catch (FileNotFoundException e) {
//			System.out.println("파일이 존재하지 않습니다.");
			e.printStackTrace();
		} catch (IOException e) {
//			System.out.println("파일을 읽을 수 없습니다.");
			memberList = null; // 참조선 제거
			e.printStackTrace();
		} finally {
			try {
				buffer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return memberList;
	}

	// 접속기록 작성
	public boolean writeAccessHistory(AccessHistoryBean accessInfo) {
		boolean result = false;
		BufferedWriter bufferedWriter = null;
		
		try {
			bufferedWriter = new BufferedWriter(new FileWriter(new File(fileInfo[accessInfo.getFileIndex()]),true));//changyong,20221026151037,1
			bufferedWriter.write(accessInfo.getAccessCode() + "," + accessInfo.getAccessDate() + "," + accessInfo.getAccessType() + "\n");
			bufferedWriter.flush(); // write로 담은 내용 출력 후, 버퍼를 비움.
			
			result = true;
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				bufferedWriter.close(); // bufferedWriter close.
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

}
