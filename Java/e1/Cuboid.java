public class Cuboid implements Solid {
	
	protected double a;
	
	protected double b;
	
	protected double c;
	
	public Cuboid(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Override
	public double surface() {
		return 2 * (a * b + a * c + b * c);
	}

	@Override
	public double volume() {
		return a * b * c;
	}

	@Override
	public String toString() {
		return "Kvader(" + a + ", " + b + ", " + c + ")";
	}

}
