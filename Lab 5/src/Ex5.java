import java.io.*;
public class Ex5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int wn= 0;
		String[] w= null; //array
		File f= new File("C:\\Users\\noriss\\Documents\\Brunel\\NC1601\\lab5_ex5.txt");
		FileReader fr= new FileReader(f);
		BufferedReader br= new BufferedReader(fr);
		String line;
		while((line=br.readLine())!= null){
			w=line.split(" ");
			//System.out.println(w);
			wn+=w.length;
		}
		System.out.println("Total number of words = " + wn);
		fr.close();
	}

}
