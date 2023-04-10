public class Lab6_ex7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(factorial(5));
	}
	
	//wt is the difference ex5 & ex7
	//recursion = call the method itself
	public static long factorial(long f) {
		if(f>1) {
			//use recursion here
			long fac=f*factorial(f-1);
			return fac;
		}
		else return 1;
		
	}

}
