package planeti;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
class Planet{
	public final int r,d;
	public double alpha = Math.PI/2;
	public final double angle;
	public Planet(int r, int d, double angle) {this.r =r;this.d =d; this.angle = angle;}
}
public class Planets extends JFrame {
static final int SUN = 48;
//2. KORAK: definiraj seznam planetov
List<Planet> planets = new ArrayList<Planet>();
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

for (Planet planet: planets) {
	g.setColor(Color.GRAY);
	int x = (int)Math.round(getWidth() / 2.0 + planet.d * Math.cos(planet.alpha));
	int y = (int)Math.round(getHeight() / 2.0 - planet.d * Math.sin(planet.alpha));
	g.fillOval(x-planet.r,y-planet.r, 2*planet.r, 2*planet.r);
	g.setColor(Color.BLACK);
	g.drawOval(getWidth() / 2 - planet.d, getHeight() / 2 - planet.d, planet.d*2,planet.d*2);
}
}
};
panel.setBackground(Color.WHITE);
add(panel);
setVisible(true);
}
public static void main(String[] args) throws InterruptedException {
Planets gui = new Planets();
// 3. KORAK: dodaj tri planete v seznam

gui.planets.add(new Planet(12, 120, Math.PI / 48));
gui.planets.add(new Planet(16, 180, Math.PI / 32));
gui.planets.add(new Planet(24, 240, Math.PI / 24));
gui.planets.add(new Planet(8, 80, Math.PI / 16));
gui.planets.add(new Planet(30, 300, Math.PI / 64));
while (true) {
// 5. KORAK: premakni planete...
	for (Planet planet: gui.planets){
		planet.alpha = planet.alpha + planet.angle;
		
	}
gui.repaint();
Thread.sleep(50); // ...na vsakih 50 ms
}
}
}