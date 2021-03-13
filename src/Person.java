
public class Person {
	String name;
	int age;
	
	static int x;
	
	Person(String n,int a){
		name=n;
		age=a;
	}
	Person(String n){
		name=n;
		age=-1;
	}
	
	Person(int age,String name){
		this.name=name;
		this.age=age;
	}
	
	void sayHello() {
		System.out.println("Hello my name is "+name);
	}
	
	void sayHello(Person another) {
		System.out.println("Hello "+another.name+" My name is "+name);
	}
	
	boolean isOlderThan(int anAge) {
		boolean flg;
		if(age>anAge) flg=true; else flg=false;
		return flg;
	}

	

}
