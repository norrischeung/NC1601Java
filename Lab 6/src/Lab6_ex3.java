public class Lab6_ex3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isleap(2020));
	}
	
	public static boolean isleap(int x) {
		boolean leap = false;
		if((x%400==0) || (x%4==0 && x%100!=0))
			leap = true;
		//System.out.println(leap); //check
		return leap ;
	}

}
