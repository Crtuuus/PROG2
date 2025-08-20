package solid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public interface Solid {
public double surface(); // površina telesa
public double volume(); // prostornina telesa
public static void main(String[] args) {
List<Solid> solids = new ArrayList<Solid>();
// 1. KORAK: implementacija teles
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
// 3. KORAK: urejanje teles
for (Solid solid: solids) {
System.out.println(solid); // 2. KORAK: izpis teles
System.out.format("S = %.2f\n", solid.surface());
System.out.format("V = %.2f\n ", solid.volume());
System.out.println();
}
}
String print();
}