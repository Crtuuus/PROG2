public class Cube extends Cuboid {

	public Cube(double a) {
		super(a, a, a);
	}
	
	@Override
	public String toString() {
		return "Kocka(" + a + ")";
	}

}
