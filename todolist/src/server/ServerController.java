package server;

//클라이언트 요청에 따른 서비스 분기
public class ServerController {

	public ServerController() {

	}

	public String controller(String clientData) { //serviceCode=1&id=changyong&password=1234
		String accessResult = null;
		String serviceCode = clientData.split("&")[0].split("=")[1];
		// serviceCode=1&id=changyong&password=1234

		if (serviceCode.equals("1")) {
			// Auth Class
			Auth auth = new Auth();
			// UserApp에 결과 통보
			accessResult = auth.accessCtl(clientData) ? "1" : "0";
		}else if(serviceCode.equals("2")) {
			// serviceCode=1&id=changyong&password=1234
			Auth auth = new Auth();
			accessResult = auth.logoutCtl(clientData) ? "1" : "0";
		}

		return accessResult;
	}
}
