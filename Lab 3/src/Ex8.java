import java.util.Scanner;

public class Ex8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String x="A", done="Done";
		Scanner mysc = new Scanner(System.in); 
		
		while (!x.equals(done)) {
			System.out.print("Input: ");
			x=mysc.nextLine();
			if(Character.isDigit(x.charAt(0)))System.out.println("This is Digit");
			else if(Character.isUpperCase(x.charAt(0))) System.out.println("This is Capital letter");
				 else if(Character.isLowerCase(x.charAt(0))) System.out.println("This is Small letter ");
				 else System.out.println("This is Sysmbol");
			
		}
		System.out.println("Thank you");
		
		
		
		
		
	}

}
