public class Lab6_ex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse("desserts"));
	}
	
	public static String reverse(String ipx) {
		//add your code here to reverse the string
		String rev="";
		for(int i=ipx.length()-1;i>=0;i--) {
			rev+=ipx.charAt(i);
		}
		return rev;
		
	}


}
