package day5;

public class Ex14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int sum = 0;
		for(int i=3;i<=15;i+=3) {
			sum +=i;
			//System.out.println(i);
		}
		System.out.println(sum);
		
		for(int i = 0;i<=15;i++) {
			if(i%3==0) {
				sum+=i;
			}
		}
		System.out.println(sum);
	}

}
