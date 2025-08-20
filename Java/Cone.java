package solid;

public class Cone implements Solid {
	protected final double r, h;
	public Cone(double r, double h) {this.r = r; this.h = h;}
	@Override
	public double surface() {
		return (Math.PI*r*r*Math.sqrt(r*r + h*h));
	}
	@Override
	public double volume() {
		return (Math.PI*r*r*h)/3;
	}
	@Override
	public String print() {
	    return String.format("Stožec (" + r + ", " + h+ " )");
	}
	@Override
	public String toString() { 
	    return print(); 
	}

}
