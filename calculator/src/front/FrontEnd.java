package front;

public class FrontEnd {
	
	private String title;
	
	// 1. 생성자가 속해 있는 block의 Class mamber list를 메모리로 loading
	// 2. (필요시) field initialization
	// 3. 클래스를 로딩할 때 단 1번만 실행 할 수 있다.
	public FrontEnd() {
		this.title = makeTitle();
	}
	
	public String makeTitle() {
		StringBuffer title = new StringBuffer();
		title.append("****************************************************\n\n");
		title.append("\tJS Framework Calculator v1.0\n");
		title.append("\t\t\tDesigned by ...\n\n");
		title.append("****************************************************");
		return title.toString();
	}
	
	public void aaa(){
		System.out.println("A" + this.title);
	}
	
	public void bbb(){
		System.out.println("B" + this.title);
	}
	
	public String makeMessage(String str) {
		StringBuffer message = new StringBuffer();
		message.append("[");
		message.append(str);
		message.append("]");
		return message.toString();
	}
	
	public String makeSubMenu(String str, String menu) {
		StringBuffer subMenu = new StringBuffer();
		subMenu.append("[");
		subMenu.append(str);
		subMenu.append("]_________________________________\n");
		
		subMenu.append(menu);
		return subMenu.toString();
	}
	
}