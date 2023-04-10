public class Lab6_ex5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(factorial(21));
	}
	
	// y it will be negative num after fac(21)
	public static long factorial(long f) {
		long fac=1;
		for(int i=1;i<=f;i++) {
			fac*=i;
		}
		return fac;
	}

}
