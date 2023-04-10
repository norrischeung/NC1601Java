public class Ex6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i,j,k;
		
		System.out.print("1) ");
		for(i=1;i<=5;i++)
		{
			for(j=1;j<i+1;j++)
			{
				System.out.print(i);
			}
		}
		
		System.out.println();
		System.out.print("2) ");
		for(i=2;i<=6;i++) {
			for(j=1;j<=i;j++) {
				System.out.print(i);
			}
		}
		
		System.out.println();
		System.out.print("3) ");
		for(i=1;i<=5;i+=2) {
			for(j=1;j<=i;j++) {
				System.out.print(i);
			}
		}
		
		k=0;
		System.out.println();
		System.out.print("4) ");
		for(i=1;i<=7;i+=2) {
			k+=1;
			for(j=1;j<=k;j++) {
				System.out.print(i);
			}
		}
		
		System.out.println();
		System.out.print("5) ");
		for(i=5;i>=1;i--) {
			for(j=1;j<=i;j++) {
				System.out.print(i);
			}
		}
		
		System.out.println();
		System.out.print("6) ");
		for(i=5;i>=1;i--) {
			for(j=1;j<=6-i;j++) {
				System.out.print(i);
			}
		}
		
		System.out.println();
		System.out.print("7) ");
		for(i=1;i<=5;i++) {
			for(j=1;j<=i;j++) {
				if(i%2==0) System.out.print("*");
				else System.out.print("+");
			}
		}
		
		System.out.println();
		System.out.print("8) ");
		for(i=1;i<=6;i++) {
			for(j=1;j<=i+1;j++) {
				if(i%3==1) System.out.print("-");
				else if(i%3==2) System.out.print("*");
					 else System.out.print("+");
			}
		}
		
	}

}
