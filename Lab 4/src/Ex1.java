import java.util.ArrayList;

public class Ex1 {
	public static void main(String[] args) {
		int i,j;
		double[] heights = {178,155,169.1,153.6,182,174.8,172.9,160.4,185,190.2};
		double temp,avg=0,min=heights[0],max=heights[0];
		
		//EX1
		System.out.println("a) " + heights.length);
		
		System.out.print("b) ");
		for(i=0;i<heights.length;i++) {
			System.out.print(heights[i] + " ");
		}
		
		for(i=0;i<heights.length;i++) {
			avg+=heights[i];
		}
		System.out.println();
		System.out.println("c) " + (avg/heights.length));
	
		for(i=0;i<heights.length;i++) {
			if(heights[i]<min) min=heights[i];
		}
		System.out.println("d) " + min);
		
		for(i=0;i<heights.length;i++) {
			if(heights[i]>max) max=heights[i];
		}
		System.out.println("e) " + max);
		
	}
}
