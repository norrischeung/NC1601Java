import java.util.ArrayList;

public class EX2 {
	public static void main(String[] args) {
		int i,j;
		double[] heights = {178,155,169.1,153.6,182,174.8,172.9,160.4,185,190.2};
		double temp;
		
		ArrayList<Double> heightsList = new ArrayList<Double>();
		for(i=0;i<heights.length;i++) {
			heightsList.add(heights[i]);
		}
		
		//a. remove
		heightsList.remove(2);
		
		//b. add
		heightsList.add(151.2);
		heightsList.add(189.3);
		heightsList.add(156.0);
		heightsList.add(166.1);
		heightsList.add(181.7);
		
		//c. sort
		for(i=0;i<heightsList.size();i++) {
			for(j=i+1;j<heightsList.size();j++) {
				if(heightsList.get(i)>heightsList.get(j)) {
					temp=heightsList.get(i);
					heightsList.set(i,heightsList.get(j));
					heightsList.set(j,temp);
				}
			}
		}
	
		//d. print
		System.out.println("Length = " + heightsList.size());
		for(i=0;i<heightsList.size();i++) {
			System.out.println(heightsList.get(i) + " ");
		}
		
		//e. min,max
		System.out.println("minimum value = " + heightsList.get(0));
		System.out.println("maximum value = " + heightsList.get(heightsList.size()-1));
	}
}
