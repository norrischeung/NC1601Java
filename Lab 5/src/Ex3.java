import java.io.*;
public class Ex3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String dir_name = "C:\\Users\\noriss\\Documents\\Brunel\\NC1601"; 
		//Or another directory. Be careful with the ¡§¡¨ that MSWord uses.
		File dir = new File(dir_name);
		File[] dir_list = dir.listFiles();
		
		System.out.println("a) ");
		for(int i=0;i<dir_list.length;++i) {
			if(dir_list[i].isDirectory()) {
				System.out.println(dir_list[i].getName() + " is Directory");
			}
			else System.out.println(dir_list[i].getName() + " is not Directory");
			
		}
		//problem: if file call .txt will not show (ok)
		System.out.println();
		System.out.println("b)");
		for(int i=0;i<dir_list.length;++i) {
			if(!(dir_list[i].getName().endsWith(".txt")) || (dir_list[i].isDirectory())) {
				System.out.println(dir_list[i].getName());
			}
		}

	}

}
