package solid;

public class Cube implements Solid {
	private final double a;
	public Cube(double a) {this.a = a;}
	@Override
	public double surface() {
		return a*a*6;
	}

	@Override
	public double volume() {
		return a*a*a;
	}
	@Override
	public String print() {
	    return String.format("Kocka ("+ a +")");
	}
	@Override
	public String toString() { 
	    return print(); 
	}

}
