
public class Ex5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a,b,i=1,hcf=0;
		
		a=88;
		b=26;
		
		while(i<=a && i<=b) {
			if(a%i==0 && b%i==0) hcf=i;
			i+=1;
		}
		System.out.println(hcf);
		
	}

}
