package izpit;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

//1. KORAK: sestavi razred Planet
class Planet{
	public int radius;
	public int distance;
	public double alpha;
	public double angle;
	Planet(int radius, int distance, double alpha, double angle) {
		this.angle = angle;
		this.distance = distance;
		this.alpha = alpha;
		this.radius = radius;
	}

}
public class Planets extends JFrame {
static final int SUN = 48;
static //2. KORAK: definiraj seznam planetov
List<Planet> planets = new ArrayList<Planet>();
//NAMIG: List<Planet> planets = new ArrayList<Planet>();
public Planets() {
super("Planets");
setSize(new Dimension(800, 600));
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
JPanel panel = new JPanel() {
@Override
public void paint(Graphics g) {
super.paint(g);
g.setColor(Color.YELLOW);
g.fillOval(getWidth() / 2 - SUN, getHeight() / 2 - SUN, 2 * SUN, 2 * SUN);
//4. KORAK: nariši planete (s krožnicami)
for (Planet planet: planets){
	g.setColor(Color.black);
	g.drawRoundRect(getWidth() / 2 - planet.distance, getHeight() / 2 - planet.distance, 2*planet.distance, 2*planet.distance, 2*planet.distance, 2*planet.distance);
	g.setColor(Color.green);
	int x = (int)Math.round(getWidth() / 2.0 + planet.distance * Math.cos(planet.alpha));
	int y = (int)Math.round(getHeight() / 2.0 - planet.distance * Math.sin(planet.alpha));
	g.fillOval(x,y ,2*planet.radius,2*planet.radius);
}
//NAMIG: for (Planet planet: planets) { }

}
};
panel.setBackground(Color.WHITE);
add(panel);
setVisible(true);
}
public static void main(String[] args) throws InterruptedException {
Planets gui = new Planets();
// 3. KORAK: dodaj tri planete v seznam
gui.planets.add(new Planet( 6,  70,0,  Math.PI/ 24));
gui.planets.add(new Planet( 8,  100,0,  Math.PI/ 36));
gui.planets.add(new Planet( 12,  120,0,  Math.PI/ 48));

// NAMIG: gui.planets.add(new Planet(12, 120, Math.PI / 48));
while (true) {
	for (Planet planet: planets) {
		planet.alpha = planet.alpha + planet.angle;
	}
// 5. KORAK: premakni planete...
gui.repaint();
Thread.sleep(25); // ...na vsakih 50 ms
}
}
}