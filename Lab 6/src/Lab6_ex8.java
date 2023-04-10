public class Lab6_ex8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(palindrome("an na"));
		System.out.println(palindrome("a toyota"));
	}
	
	public static boolean palindrome(String p) {
		boolean pali;
		String rev="";
		for(int i=p.length()-1;i>=0;i--) {
			rev+=p.charAt(i);
		}
		if(rev.equals(p)) {
			pali=true;
		}
		else pali=false;
		System.out.println(rev);
		return pali;
	}
}
