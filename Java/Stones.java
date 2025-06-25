package izpit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Stones extends JFrame {
static final int RADIUS = 10; // polmer kamnov
// 2. KORAK: definicija seznama kamnov (NAMIG: List<Stone> stones)
private static List<Stone> stones= new ArrayList<Stone>();
public Stones(){
	super("Stones");

setTitle("Stones");
setSize(new Dimension(1024, 768));
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
JPanel panel = new JPanel() {
@Override
public void paint(Graphics g) {
super.paint(g);
// 3. KORAK: izris kamnov in valov (NAMIG: g.drawOval(...))
for (Stone stone: stones){
	g.fillOval(stone.x,stone.y ,Stones.RADIUS,Stones.RADIUS);
	 // val kot obroba
    g.setColor(Color.BLUE);
    g.drawOval(stone.x - stone.radius, stone.y - stone.radius,
               2*stone.radius, 2*stone.radius);
    g.setColor(Color.GRAY);
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
        // ko uporabnik klikne, dodamo nov kamen z začetnim radialnim valom
        stones.add(new Stone(e.getX(), e.getY(), RADIUS));
        panel.repaint();
    }
});
// 6. KORAK:
panel.addKeyListener(new KeyAdapter() {
    @Override
    public void keyPressed(KeyEvent e) {
        stones.clear();     // odstrani vse kamne
        panel.repaint();    // osveži risanje
    }
});

}
public static void main(String[] args) throws InterruptedException {
Stones GUI = new Stones();
GUI.setVisible(true);
while (true) {
// 4. KORAK: animacija širjenja valov (NAMIG: stone.radius++)
	for (Stone stone: stones){
		stone.radius++;
	}
GUI.repaint();
Thread.sleep(25);
}
}
}
class Stone {
// 1. KORAK: definicija razreda Stone (NAMIG: int x, y, radius)
	public int radius;
	public int y;
	public int x;
	Stone(int x, int y, int radius) {
	this.radius = radius;
	this.x = x;
	this.y= y;
	}
}