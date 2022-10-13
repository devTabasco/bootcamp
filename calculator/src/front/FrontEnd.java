package front;

import back.BackEnd;

public class FrontEnd {
	
	// 1. 생성자가 속해 있는 block의 Class mamber list를 메모리로 loading
	// 2. (필요시) field initialization
	// 3. 클래스를 로딩할 때 단 1번만 실행 할 수 있다.
	public FrontEnd() {
		System.out.println("나는 프론트엔드");
		BackEnd backEnd = new BackEnd();
		
		System.out.println(backEnd.add(1, 2, '+'));
		
	}
	
	
}
