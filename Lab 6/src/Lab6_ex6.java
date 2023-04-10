public class Lab6_ex6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(charcount("abracadabra", 'a'));
	}
	
	public static int charcount(String ipx, char c) {
		//add your code here to count the frequency of c in ipx
		int count=0;
		for(int i=0;i<ipx.length();i++) {
			if(ipx.charAt(i)==c) {
				count+=1;
			}
		}
		return count;
	}


}
