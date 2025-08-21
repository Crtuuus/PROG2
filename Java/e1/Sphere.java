public class Sphere implements Solid {
	
	protected double r;
	
	public Sphere(double r) {
		this.r = r;
	}

	@Override
	public double surface() {
		return 4 * Math.PI * r * r;
	}

	@Override
	public double volume() {
		return 4 * Math.PI * r * r * r / 3;
	}

	@Override
	public String toString() {
		return "Krogla(" + r + ")";
	}

}
