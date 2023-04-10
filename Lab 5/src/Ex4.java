import java.util.Random;
import java.util.Scanner; 

public class Ex4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		int min,max,temp;
		System.out.println("Input first interger a:");
		min=sc.nextInt();
		System.out.println("Input second interger b:");
		max=sc.nextInt();
		if(min>max) {
			temp=max;
			max=min;
			min=temp;
		}
		
		System.out.println("\na) ");
		for(int i=0;i<10;++i){
			System.out.println(rand.nextInt(201)-100);
		}
		System.out.println();
		//read input
		System.out.println("b) Range = " + min + " to " + max);
		for(int i=0;i<10;++i){
			System.out.println(rand.nextInt(max-min+1)+min);
		}
		System.out.println();
		System.out.println("c) ");
		for(int i=0;i<10;++i){
			System.out.println(rand.nextDouble());
		}
		System.out.println();
		System.out.println("d) Range = " + min + " to " + max);
		for(int i=0;i<10;++i){
			System.out.println(min+(max-min)*rand.nextDouble());
		}
		

	}

}
