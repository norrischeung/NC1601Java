import java.util.Scanner;
import java.util.ArrayList;
public class Ex7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<String> arr = new ArrayList<String>();
		String input = "";
		while(!input.equals("done")) {
			System.out.println("Input a word: ");
			System.out.println("Enter 'done' when you finish entering");
			input = sc.nextLine();
			arr.add(input);
		}
		//System.out.println(arr);
		//check the length of longest word
		int i,max=0;
		for(i=0;i<arr.size();i++) {
			if(arr.get(i).length()>max) {    
				max=arr.get(i).length();
			}
		}
		
		//print word
		int ans=0;
		System.out.print("Result: ");
		for(i=0;i<arr.size();i++) {
			if(arr.get(i).length()==max) { 
				ans+=1;
				if(ans>1) {
					System.out.print(", ");
				}
				System.out.print(arr.get(i));
			}
		}
		
		
		
	}

}
