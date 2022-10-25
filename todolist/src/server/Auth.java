package server;

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

	public boolean accessCtl(String clientData) {
		// clientData 분리 후
		// id는 MemberBean.setAccessCode();
		// pw는 MemberBean.setSecretCode();
		
		MemberBean memberBean = this.setMemberBean(clientData);
		System.out.println(memberBean.getAccessCode());
		System.out.println(memberBean.getSecretCode());
		
		return true;
	}

	private MemberBean setMemberBean(String clientData) {
		MemberBean memberBean = new MemberBean();

		String[] splitData = clientData.split("&");
		memberBean.setAccessCode(splitData[1].split("=")[1]);
		memberBean.setSecretCode(splitData[2].split("=")[1]);

		return memberBean;
	}

	// AccessCode 존재여부 확인
	// recode넘버를 보내주면 안됨?
	private boolean compareAccessCode() {

		return true;
	}

	// AccessCode와 SecretCode의 비교
	private boolean isAuth() {
		return false;
	}

}
