package server;

/* 클라이언트 요청에 따른 서비스 분기 */
public class ServerController {
	
	public ServerController() {}
	
	public String controller(String clientData) {
		Auth auth = null;
		TaskManager task = null;
		String result = null;
		String serviceCode = (clientData.split("&")[0]).split("=")[1];
				
		if(serviceCode.equals("1")) {
			auth = new Auth();
			result = auth.accessCtl(clientData)? "1": "0";
		}else if(serviceCode.equals("-1")) {
			auth = new Auth();
			auth.accessOut(clientData);
			result = "로그아웃 완료";
		}else if(serviceCode.equals("9")) {
			task = new TaskManager();
			result = task.getTodoDateCtl(clientData);
		}
		
		return result; 
	}
}
