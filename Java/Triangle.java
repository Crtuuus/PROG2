package izpit;

public class Triangle implements Shape{
	private final double a;
	public Triangle(double a) {
		this.a = a;
	}
	@Override
	public String print() {
		// TODO Auto-generated method stub
		return "Triangle(" + a + ")";
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return (Math.sqrt(3)/4)*a*a;
	}

	@Override
	public double perimeter() {
		// TODO Auto-generated method stub
		return 3*a;
	}
	

}
