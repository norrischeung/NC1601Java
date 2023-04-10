import java.util.ArrayList;

public class Ex7 {
	private String name; //Field (class variable)
	//private = modifier, String = data type, name= field name
	private int age; //Field (class variable)
	
	public String getName() { //getters
	//public = modifier, String= return type, getName= method Name
		return name;
	}

	public int getAge()	{ //getters
		return age;
	}

	public void printInfo()	{ //Method, print name age
		System.out.println("Name: "+ getName());
		System.out.println("Age: "+ getAge());
		System.out.println("*******************");
	}
	
	private static void printMemberData(ArrayList<Member> mylist) {
		for(int i=0;i<mylist.size();i++) {
			Member person=mylist.get(i);
			person.printInfo();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Member> mylistA = new ArrayList<Member>();
		ArrayList<Member> mylistB = new ArrayList<Member>();
		ArrayList<Member> mylistC = new ArrayList<Member>();
		ArrayList<Member> mylistD = new ArrayList<Member>();
		Member member1 = new Member("Lela",41);
		Member member2 = new Member("Leonardo",21);
		Member member3 = new Member("Michelangelo",43);	
		
		mylistA.add(member1);
		mylistA.add(member2);
		mylistA.add(member3);
		
		printMemberData(mylistA);
		System.out.println();
		
		mylistB = mylistA; //copy listA to listB
		printMemberData(mylistB);
		System.out.println();
		
		mylistA.remove(1);
		printMemberData(mylistB); //listB will change if list A change
		
		System.out.println("list C , D");
		mylistC.add(member1);
		mylistC.add(member2);
		mylistC.add(member3);
		
		printMemberData(mylistC);
		System.out.println();
		mylistD = (ArrayList<Member>)mylistC.clone(); //list C and D are individual
		mylistC.remove(1);
		printMemberData(mylistC);
		System.out.println();
		printMemberData(mylistD);
		System.out.println();
		
	}

}
