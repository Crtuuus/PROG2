package solid;

public class Cuboid implements Solid {
	public final double a,b,c;
	public Cuboid(double a,double b,double c) {this.a=a;this.b=b;this.c=c;}
	@Override
	public double surface() {
		return 2*(a*b+b*c+a*c);
	}

	@Override
	public double volume() {
		// TODO Auto-generated method stub
		return a*b*c;
	}
	@Override
	public String print() {
	    return String.format("Kvader ("+ a +", "+ b +", "+ c +")");
	}
	@Override
	public String toString() { 
	    return print(); 
	}
}
