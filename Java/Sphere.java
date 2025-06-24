package yee;

public class Sphere implements Solid{
	private final double r;
	public Sphere(double r){
	this.r = r;
}
	 @Override
	    public double surface() {
	        return 4 * Math.PI * r * r;
	    }

	    @Override
	    public double volume() {
	        return 4.0/3.0 * Math.PI * r * r * r;
	    }

}
