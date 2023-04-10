
public class Ex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Question 2,4,7
		int i;
		
		System.out.print("1. ");
		for(i=4;i<=11;i++) {
			System.out.print(i);
			if(i<11) System.out.print(",");
		}
		
		System.out.println(" ");
		System.out.print("2. ");
		for(i=10;i<=19;i+=3) {
			System.out.print(i);
			if(i<19) System.out.print(",");
		}
		
		System.out.println(" ");
		System.out.print("3. ");
		for(i=1;i<=16;i+=3) {
			System.out.print(i);
			if(i<16) System.out.print(",");
		}
		
		System.out.println(" ");
		System.out.print("4. ");
		for(i=2;i<=12;i+=2) {
			System.out.print(i);
			if(i<12) System.out.print(",");
		}
		
		int x;
		System.out.println(" ");
		System.out.print("5. ");
		for(i=1;i<=10;i++) {
			x=i*i;
			System.out.print(x);
			if(i<10) System.out.print(",");
		}
		
		System.out.println(" ");
		System.out.print("6. ");
		for(i=-10;i<=10;i+=2) {
			System.out.print(i);
			if(i<10) System.out.print(",");
		}
		
		System.out.println(" ");
		System.out.print("7. ");
		for(i=-20;i<=20;i+=5) {
			if (i==0) i+=5;
			System.out.print(i);
			if(i<20) System.out.print(",");
		}
		
	}

}
