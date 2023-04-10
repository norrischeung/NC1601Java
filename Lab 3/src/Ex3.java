public class Ex3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i;
		
		System.out.print("1) ");
		for(i=0;i<10;i++) {
			System.out.print("+");
		}
		
		System.out.println(" ");
		System.out.print("2) ");
		for(i=0;i<9;i++) {
			System.out.print("-");
		}
		
		System.out.println(" ");
		System.out.print("3) ");
		for(i=0;i<10;i++) {
			if(i%2==0) System.out.print("+");	
			else System.out.print("-");
		}
		
		System.out.println(" ");
		System.out.print("4) ");
		for(i=0;i<3;i++) {
			System.out.print("*+-");
		}
		
		System.out.println(" ");
		System.out.print("5) ");
		for(i=1;i<=10;i++) {
			if(i%3==1) System.out.print("*");
			else if(i%3==2) System.out.print("+");
				 else System.out.print("-");
		}
		
		System.out.println(" ");
		System.out.print("6) ");
		for(i=0;i<3;i++) {
			System.out.print("**++");
		}
		
		System.out.println(" ");
		System.out.print("7) ");
		for(i=0;i<2;i++) {
			System.out.print("**++--");
		}
		
		System.out.println(" ");
		System.out.print("8) ");
		for(i=1;i<=6;i++) {
			if(i==1 || i==6) System.out.print("***");
			else if(i==2 || i==5) System.out.print("+++");
				 else System.out.print("---");
		}
		
	}
}
