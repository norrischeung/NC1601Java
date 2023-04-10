public class Lab6_ex4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int month=2;
		int year=2020;
		int days= numofdays(month,year);
		System.out.println(month + "."+ year +" have " + days +" days");
		
	}
	
	public static boolean isleap(int x) {
		boolean leap = false;
		if((x%400==0) || (x%4==0 && x%100!=0))
			leap = true;
		//System.out.println(leap); //check
		return leap ;
	}
	
	public static int numofdays(int m, int y) {
		int d=0;
		switch(m) {
		case 1,3,5,7,8,10,12:
			d=31;
			break;
		case 4,6,9,11:
			d=30;
			break;
		case 2:{
			if(isleap(y)) d=29;
			else d=28;
			break; }
		default:
			d=0;
			break;
		}
		return d;
	}

}
