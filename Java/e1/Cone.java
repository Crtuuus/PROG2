public class Cone implements Solid {
	
	protected double r;
	
	protected double h;
	
	public Cone(double r, double h) {
		this.r = r;
		this.h = h;
	}

	@Override
	public double surface() {
		return Math.PI * r * r + Math.PI * r * Math.sqrt(r * r + h * h);
	}

	@Override
	public double volume() {
		return Math.PI * r * r * h / 3;
	}

	@Override
	public String toString() {
		return "Stožec(" + r + ", " + h + ")";
	}

}
