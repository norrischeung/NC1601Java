import java.util.ArrayList;
public class Member { //class
	private String name; //Field (class variable)
	//private = modifier, String = data type, name= field name
	private int age; //Field (class variable)
	
	public Member(String n,int a) { //Constructors
		name = n;
		age = a;
	}
	public String getName() { //Method, getters
	//public = modifier, String= return type, getName= method Name
		return name;
	}
	public void setName(String newname) { //Method, setters
		name = newname;
	}
	public int getAge()	{ //getters
		return age;
	}
	public void setAge(int newage)	{ //setters
		age = newage;
	}
	public void printInfo()	{ //Method, print name age
		System.out.println("Name: "+ getName());
		System.out.println("Age: "+ getAge());
		System.out.println("*******************");
	}
	
}
