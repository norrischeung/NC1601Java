import java.lang.Math;
public class Ex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RoundingTest(100.9);
	}
	//9-20 which type of method
	private static void RoundingTest(double x) {
	//add your code here to apply floor, round and ceil on x
		double c,f,r;
		c=Math.ceil(x);
		f=Math.floor(x);
		r=Math.round(x);
		String input= String.format("For %1$.6f ",x);
		String ceil= String.format("ceil = %1$.6f ",c);
		String floor= String.format("floor = %1$.6f ",f);
		String round= String.format("round = %1$.0f",r);
		System.out.println(input + ceil + floor + round);
	}
	//b	:
	//For -100.100000 ceil = -100.000000 floor = -101.000000 round = -100
	//For -100.490000 ceil = -100.000000 floor = -101.000000 round = -100
	//For -100.500000 ceil = -100.000000 floor = -101.000000 round = -100
	//For -100.510000 ceil = -100.000000 floor = -101.000000 round = -101
	//For -100.900000 ceil = -100.000000 floor = -101.000000 round = -101
	//For 0.000000 ceil = 0.000000 floor = 0.000000 round = 0
	//For 100.100000 ceil = 101.000000 floor = 100.000000 round = 100
	//For 100.490000 ceil = 101.000000 floor = 100.000000 round = 100
	//For 100.500000 ceil = 101.000000 floor = 100.000000 round = 101
	//For 100.510000 ceil = 101.000000 floor = 100.000000 round = 101
	//For 100.900000 ceil = 101.000000 floor = 100.000000 round = 101



}
