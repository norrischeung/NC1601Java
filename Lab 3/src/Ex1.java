
public class Ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x;
		

		
		for(x=1;x<=100;x++) {
			if (x%2==0 && x%3==0) System.out.println(x + " can divisible by 2 and 3");
			else System.out.println(x + " cannot divisible by 2 and 3");
			//x is multiple of 2 and 3
		}

		for(x=1;x<=100;x++) {
			if (x%7==0 || x%9==0) System.out.println(x + " can divisible by 7 or 9");
			else System.out.println(x + " cannot divisible by 7 or 9");
		}
		
		for(x=1;x<=100;x++) {
			if (x%2==0 && x%3==0 && x%5!=0) System.out.println(x + " can divisible by 2 and 3 but not 5");
			else System.out.println(x + " cannot divisible by 2 and 3 but not 5");
		}
		

	}

}
