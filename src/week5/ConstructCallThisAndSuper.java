package week5;

class ConstructCallThisAndSuper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p = new Graduate();
		//System.out.println(p instanceof String);
	}

}


class Person {
	String name;
	int age;
	Person(){System.out.println("In Person()");}
	Person(String name, int age){
		this.name = name;
		this.age = age;
		System.out.println("In Person(String,int)");
	}
}


class Student extends Person{
	String school;
	Student(){
		this(null, 0, null);
		System.out.println("In Student()");
	}
	
	Student(String name, int age, String school){
		super(name, age);
		this.school = school;
		System.out.println("In Student(String,int,String)");
	}
}

class Graduate extends Student{
	String teacher = "";
	Graduate(){
		System.out.println("In Graduate()");
	}
}
