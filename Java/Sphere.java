package solid;

public class Sphere implements Solid {
	public final double r;
	public Sphere(double r) {this.r = r;}
	@Override
	public double surface() {
		return 4*r*Math.PI;
	}

	@Override
	public double volume() {
		return r*r*r*Math.PI*4/3;
	}
	@Override
	public String print() {
	    return String.format("Krogla("+ r + ")");
	}
	@Override
	public String toString() { 
	    return print(); 
	}

}
