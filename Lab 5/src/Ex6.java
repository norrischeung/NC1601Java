import java.io.*;
import java.lang.Math;
public class Ex6 {

	public static void main(String args[]) throws IOException {
		writefile(5,"C:\\Users\\noriss\\Documents\\Brunel\\NC1601\\lab5_ex6.txt" );
	}
	
	public static void writefile(int n, String filename)throws IOException{
	   FileWriter writehandle = new FileWriter(filename);

	//complete the rest of the code to write in the file
	   BufferedWriter bw = new BufferedWriter(writehandle);
	   
	   String line;
	   line = "a) ";
	   bw.write(line);
	   bw.newLine();
	   
	   for(int i=1;i<=n;i++) {
		   double sr = Math.sqrt(i);
		   line = i + ": " + sr;
		   bw.write(line);
		   bw.newLine();
	   }
	   
	   /*
	   for(int i=1;i<=n;i++) {
		   double sr = Math.sqrt(i);
		   line = i + String.format(": %.if",sr);
		   bw.write(line);
		   bw.newLine();
	   }
	   */
	   
	   line = "b) ";
	   bw.write(line);
	   bw.newLine();
	   
	   line = String.format("1: %.1f",Math.sqrt(1));
	   bw.write(line);
	   bw.newLine();
	   
	   line = String.format("2: %.2f",Math.sqrt(2));
	   bw.write(line);
	   bw.newLine();
	   
	   line = String.format("3: %.3f",Math.sqrt(3));
	   bw.write(line);
	   bw.newLine();
	   
	   line = String.format("4: %.4f",Math.sqrt(4));
	   bw.write(line);
	   
	   
	   bw.close();
	   writehandle.close();
	}
	

}
