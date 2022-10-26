package server;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import server.beans.AccessHistoryBean;
import server.beans.MemberBean;

//Login, Logout, Log history
public class Auth {

	public Auth() {

	}

//	job : 로그인
//	1. parameter : id, pw
//	2. id가 DB에 존재하는지 확인
//		--> DAO가 MEMBERS 전체 레코드를 전달 --> 비교
//		2-1. true : p3
//		2-2. false : client
//	3. id와 pw를 db와 비교
//		3-1. true : p4
//		3-2. false : client
//	4. 접속기록(로그) 생성
//	5. client에 결과 통보
	
	public boolean logoutCtl(String clientData) {
		MemberBean memberBean = this.setMemberBean(clientData);
		DataAccessObject dao = new DataAccessObject();
		AccessHistoryBean accessHistoryBean;
		boolean logoutResult = false;
		
		//historybean에 값을 저장
		//fileIndex(1), accessCode, date, accessType(-1)
		accessHistoryBean = new AccessHistoryBean();
		accessHistoryBean.setFileIndex(1);
		accessHistoryBean.setAccessCode(memberBean.getAccessCode());
		accessHistoryBean.setAccessDate(getDate(false));
		accessHistoryBean.setAccessType(-1);
		
		logoutResult = dao.writeAccessHistory(accessHistoryBean);
		
		return logoutResult;
	}

	public boolean accessCtl(String clientData) { //serviceCode=1&id=changyong&password=1234
		// clientData 분리 후
		// id는 MemberBean.setAccessCode();
		// pw는 MemberBean.setSecretCode();
		
		MemberBean memberBean = this.setMemberBean(clientData); //내가 적은 id, pw가 담긴 memberBean.
		DataAccessObject dao = new DataAccessObject();
		ArrayList<MemberBean> memberList = dao.readDatabase(0);
		AccessHistoryBean accessHistoryBean;
		boolean accessResult = false;
		
		if(compareAccessCode(memberBean.getAccessCode(),memberList)) {
			if(isAuth(memberBean,memberList)) {
				//로그인 가능
				//historybean에 값을 저장
				//fileIndex(1), accessCode, date, accessType(1)
				//로그 기록
				accessHistoryBean = new AccessHistoryBean();
				accessHistoryBean.setFileIndex(1);
				accessHistoryBean.setAccessCode(memberBean.getAccessCode());
				accessHistoryBean.setAccessDate(getDate(false));
				accessHistoryBean.setAccessType(1);
				
				//로그인 결과 넘겨주기
				accessResult = dao.writeAccessHistory(accessHistoryBean);
				
			}else {
				//로그인 불가
			}
		}
		
		return accessResult;
	}
	
	private String getDate(boolean isDate) {
		String pattern = (isDate)? "yyyyMMdd": "yyyyMMddHHmmss";
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern(pattern)); 
	}

	private MemberBean setMemberBean(String clientData) {
		MemberBean memberBean = new MemberBean();

		String[] splitData = clientData.split("&");
		memberBean.setAccessCode(splitData[1].split("=")[1]); // changyong
		memberBean.setSecretCode(splitData[2].split("=")[1]); // 1234

		return memberBean;
	}

	// AccessCode 존재여부 확인
	private boolean compareAccessCode(String accessCode, ArrayList<MemberBean> memberList) {
		boolean result = false;
		
		for(MemberBean member : memberList) {
			if(accessCode.equals(member.getAccessCode())) {
				result = true;
				break;
			}
		}
		
		return result;
	}

	// AccessCode와 SecretCode의 비교
	private boolean isAuth(MemberBean memberBean, ArrayList<MemberBean> memberList) {
		boolean result = false;
		
		for(MemberBean member : memberList) {
			if(memberBean.getAccessCode().equals(member.getAccessCode())) {
				if(memberBean.getSecretCode().equals(member.getSecretCode())) {
					result = true;
					break;
				}
			}
		}
		
		return result;
	}

}
