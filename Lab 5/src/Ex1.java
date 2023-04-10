import java.lang.Math;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
public class Ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double x= 123.456, y= 17.0/3.0, z= Math.sqrt(2);
		String a= "Hello", b="World";
		
		DecimalFormat num = new DecimalFormat("#.###");
		String form = num.format(y);
		System.out.println("a) " + form);
		
		String strx = String.valueOf(x);
		String stry = String.valueOf(y);
		String strz = String.valueOf(z);
		String[] arrx = strx.split("\\.");
		String[] arry = stry.split("\\.");
		String[] arrz = strz.split("\\.");
		//. is a regular expression means any character
		
		System.out.println();
		System.out.println("b) x: ");
		System.out.println(arrx[0].length() + " digits before decimal point");
		System.out.println(arrx[1].length() + " digits after decimal point");
		System.out.println("y:");
		System.out.println(arry[0].length() + " digits before decimal point");
		System.out.println(arry[1].length() + " digits after decimal point");
		System.out.println("z:");
		System.out.println(arrz[0].length() + " digits before decimal point");
		System.out.println(arrz[1].length() + " digits after decimal point");
		
		String c="";
		for(int i=a.length()-1;i>=0;i--) {
			c+=a.charAt(i);
		}
		c+=" " + b;
		System.out.println();
		System.out.println("c) " + c);
		
		System.out.println();
		System.out.println("d) " + c.replace("ll","ppp"));
		
	}
 

 

}
