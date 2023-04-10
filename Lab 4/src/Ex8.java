public class Ex8 {
	private static void PrintArray(int[][] array){
		for(int i=0;i<array.length;++i) {
			for(int j=0;j<array[i].length;++j) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] myarray= new int[3][10];
		int i,j,x=3,y=10;
		
		for(i=0;i<x-1;i++) {
			for(j=0;j<y;j++) {
				myarray[i][j]=(j+1)*25;
			}
		}
		for(j=0;j<y;j++) {
			myarray[x-1][j]=5000;
		}
		
		PrintArray(myarray);
		
		
	}

}
