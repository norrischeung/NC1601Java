import java.util.ArrayList;

public class EX5 {
	private static void printMemberData(ArrayList<Member> mylist) {
		for(int i=0;i<mylist.size();i++) {
			Member person=mylist.get(i);
			person.printInfo();
		}
	}
	
	public static void main(String args[]) {
		ArrayList<Member> memberList = new ArrayList<Member>();
		Member member1 = new Member("Lela",41);
		Member member2 = new Member("Leonardo",21);
		Member member3 = new Member("Michelangelo",43);
		//classname objname = new constructorname (parameters);
		Member member4 = new Member("Rafaelo",37);
		Member member5 = new Member("Donatelo",58);
		
		memberList.add(member1);
		memberList.add(member2);
		memberList.add(member3);
		memberList.add(member4);
		//e
		memberList.add(2,member5);
			
		printMemberData(memberList); 
	}
}
