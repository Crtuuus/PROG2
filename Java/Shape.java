package izpit;

public interface Shape {
	public String print(); // izpis lika
	public double area(); // površina lika
	public double perimeter(); // obseg lika
	public static void main(String[] args) {
		Shape[] shapes = new Shape[] { new Circle(1.0), new Rectangle(1.0, 2.0),
		new Square(2.0), new Triangle(2.0) };
		for (Shape shape: shapes) {System.out.println("lik = " + shape.print());
		System.out.println("ploščina = " + shape.area());
		System.out.println("obseg = " + shape.perimeter());
		System.out.println();
		}
		}
}
