import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public interface Solid {
	
	public double surface();
	
	public double volume();

	public static void main(String[] args) {
		List<Solid> solids = new ArrayList<Solid>();
		
		solids.add(new Cuboid(2.0, 3.0, 4.0));
		solids.add(new Cube(3.0));
    solids.add(new Cone(1.0, 4.0));
		solids.add(new Sphere(1.0));

		Collections.sort(solids, new Comparator<Solid>() {
			@Override
			public int compare(Solid fst, Solid snd) {
				if (fst.volume() == snd.volume())
					return new Double(fst.surface()).compareTo(snd.surface());
				return new Double(fst.volume()).compareTo(snd.volume());
			}
		});
		
		for (Solid solid: solids) {
			System.out.println(solid);
			System.out.format("S = %.2f\n", solid.surface());
			System.out.format("V = %.2f\n ", solid.volume());
			System.out.println();
		}
	}

}
