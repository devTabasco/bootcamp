package server;
import server.beans.TodoBean;

public class CreateList {

	public CreateList() {
	}

	public boolean createListCtl(String clientData) {
		TodoBean todoBean = (TodoBean) this.setBean(clientData); // 내가 적은 id, pw가 담긴 memberBean.
		DataAccessObject dao = new DataAccessObject();
		TodoBean saveTodoBean;
		boolean result = false;

		saveTodoBean = new TodoBean();
		saveTodoBean.setFileIndex(2);
		saveTodoBean.setAccessCode(todoBean.getAccessCode());
		saveTodoBean.setStartDate(todoBean.getStartDate());
		saveTodoBean.setEndDate(todoBean.getEndDate());
		saveTodoBean.setContents(todoBean.getContents());
		saveTodoBean.setStatus("0");
		saveTodoBean.setIsEnable("1");
		saveTodoBean.setIsAll(false);
		saveTodoBean.setComment("null");

		// 로그인 결과 넘겨주기
		result = dao.writeTodoList(saveTodoBean);

		return result;
	}

	private Object setBean(String clientData) {
		Object object = null;
		String[] splitData = clientData.split("&");

		if (splitData[0].split("=")[1].equals("2")) {
			object = new TodoBean();
			((TodoBean) object).setAccessCode(splitData[1].split("=")[1]);
			((TodoBean) object).setStartDate(splitData[2].split("=")[1]);
			((TodoBean) object).setEndDate(splitData[3].split("=")[1]);
			((TodoBean) object).setContents(splitData[4].split("=")[1]);
		}
		return object;
	}
}