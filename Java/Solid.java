package yee;

import java.util.ArrayList;
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
// 3. KORAK: urejanje teles
for (Solid solid: solids) {
System.out.println(solid); // 2. KORAK: izpis teles
System.out.format("S = %.2f\n", solid.surface());
System.out.format("V = %.2f\n ", solid.volume());
System.out.println();
}
}
}