import java.util.ArrayList;
public class Heights {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		
		//EX2
		ArrayList<Double> heightsList = new ArrayList<Double>();
		for(i=0;i<heights.length;i++) {
			heightsList.add(heights[i]);
		}
		
		//remove
		heightsList.remove(2);
		
		//add
		heightsList.add(170.0);
		heightsList.add(189.3);
		heightsList.add(156.0);
		heightsList.add(166.1);
		heightsList.add(181.7);
		
		//sort
		for(i=0;i<heightsList.size();i++) {
			for(j=i+1;j<heightsList.size();j++) {
				if(heightsList.get(i)>heightsList.get(j)) {
					temp=heightsList.get(i);
					heightsList.set(i,heightsList.get(j));
					heightsList.set(j,temp);
				}
			}
		}
	
		//print
		System.out.println("Length = " + heightsList.size());
		for(i=0;i<heightsList.size();i++) {
			System.out.println(heightsList.get(i) + " ");
		}
		
		//min,max
		System.out.println("minimum value = " + heightsList.get(0));
		System.out.println("maximum value = " + heightsList.get(heightsList.size()-1));
		
		
		
		
		
		
	}

}
