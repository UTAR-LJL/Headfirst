
public class TestStaticInvoke {
	
	static void doStuff(Shape s) {
		s.draw();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle c = new Circle();
		Triangle t = new Triangle();
		Line L = new Line();
		doStuff(c);
		doStuff(t);
		doStuff(L);
		Shape s = new Circle();
		doStuff(s);
		s.draw();
		
		Circle c2 = new Circle();
		c2.draw();
		
	}

}

class Shape
{
	void draw(){ System.out.println("Shape Drawing"); }
}
class Circle extends Shape
{
	void draw(){ System.out.println("Draw Circle"); }
}

class Triangle extends Shape
{
	void draw(){ System.out.println("Draw Three Lines"); }
}

class Line extends Shape
{
	void draw(){ System.out.println("Draw Line"); }
}
