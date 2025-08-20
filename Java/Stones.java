package stones;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Stones extends JFrame {
static final int RADIUS = 10; // polmer kamnov
// 2. KORAK: definicija seznama kamnov (NAMIG: List<Stone> stones)
List<Stone> stones = new ArrayList<Stone>();

public Stones() {
super();
setTitle("Stones");
setSize(new Dimension(1024, 768));
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
JPanel panel = new JPanel() {
@Override
public void paint(Graphics g) {
super.paint(g);
// 3. KORAK: izris kamnov in valov (NAMIG: g.drawOval(...))
for (Stone stone: stones) {
	g.setColor(Color.GRAY);
	g.fillOval(stone.x - RADIUS, stone.y - RADIUS, 2 * RADIUS, 2 * RADIUS);
	g.setColor(Color.WHITE);
	g.drawOval(stone.x-stone.radius,stone.y-stone.radius, 2*stone.radius,2*stone.radius);
}
}
};
panel.setBackground(new Color(174, 198, 207));
panel.setFocusable(true);
add(panel);
// 5. KORAK: miškin poslušalec za dodajanje kamnov
panel.addMouseListener(new MouseAdapter() {
	@Override
	public void mousePressed(MouseEvent e) {
		stones.add(new Stone(e.getX(),e.getY()));
		repaint();
	}
});
//6. KORAK: poslušalec tipkovnice za odstranjevanje kamnov
panel.addKeyListener(new KeyAdapter() {
	@Override
	public void keyPressed(KeyEvent e) {
		stones.clear();
		repaint();
	}
});

add(panel);
}

public static void main(String[] args) throws InterruptedException {
Stones GUI = new Stones();
GUI.setVisible(true);
while (true) {
// 4. KORAK: animacija širjenja valov (NAMIG: stone.radius++)
	for (Stone stone: GUI.stones){
		stone.radius++;
	}
	
	
GUI.repaint();
Thread.sleep(25);
}
}
//1. KORAK: definicija razreda Stone (NAMIG: int x, y, radius)
class Stone{
	int x;
	int y;
	int radius;
public Stone(int x, int y) {
	this.x =x;
	this.y =y;
	radius = Stones.RADIUS;

}	
}}