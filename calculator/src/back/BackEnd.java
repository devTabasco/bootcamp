package back;

public class BackEnd {

	public BackEnd() {
		
	}

	public long controller(long num1, long num2, char operator) {
		// operator를 byte단위로 보내면 메모리 절약

		long result;

		if (operator == '+') {
			result = num1 + num2;
		} else if (operator == '-') {
			result = num1 - num2;
		} else if (operator == '*') {
			result = num1 * num2;
		} else {
			result = num1 / num2;
		}

		return result;

	}

	public long add(long num1, long num2, char operator) {
		return num1 + num2;
	}

	public long minus(long num1, long num2, char operator) {
		return num1 - num2;
	}

	public long multiple(long num1, long num2, char operator) {
		return num1 * num2;
	}

	public long devide(long num1, long num2, char operator) {
		return num1 / num2;
	}
}