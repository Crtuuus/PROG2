package izpit;

public class Rectangle implements Shape{
	protected final double a;
	private final double b;
	
	public Rectangle(double a,double b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public String print() {
		// TODO Auto-generated method stub
		return "Rectangle(" + a + "," + b + ")";
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return a*b;
	}

	@Override
	public double perimeter() {
		// TODO Auto-generated method stub
		return 2*(a+b);
	}

}
