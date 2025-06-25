package izpit;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Bouncing extends JFrame {
static final int NUMBER = 10; // število žogic
static final int SIZE = 40; // velikost žogic
// 2. KORAK: definicija žogic (NAMIG: List<Ball> balls)
private static List<Ball> balls= new ArrayList<Ball>();
private volatile static boolean paused = false;
public Bouncing() {
super("Bouncing");
setResizable(false);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
JPanel panel = new JPanel() {
@Override
public void paint(Graphics g) {
super.paint(g);
// 4. KORAK: izris žogic (NAMIG: g.fillOval(...))
for (Ball ball: balls){
	g.setColor(Color.black);
	g.fillOval(ball.x - Bouncing.SIZE/2,ball.y - Bouncing.SIZE/2, Bouncing.SIZE,Bouncing.SIZE);
}
}
};
panel.setPreferredSize(new Dimension(400, 800));
panel.setBackground(Color.WHITE);
panel.setFocusable(true);
add(panel);
pack();

// 3. KORAK: inicializacija žogic (NAMIG: new Ball(...))
int i = 1;
while (i < 11) {
	balls.add(new Ball(getWidth()/2, getHeight() + 20 - getHeight()*i / 10, 10 + i));
	i++;
}

// 6. KORAK: poslušalec tipkovnice za nadzor animacije
panel.addKeyListener(new KeyAdapter() {
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_P) {
            paused = !paused;
            System.out.println(paused ? "Paused" : "Resumed");
        }
    }
}
);
}
public static void main(String[] args) throws InterruptedException {
Bouncing GUI = new Bouncing();
GUI.setVisible(true);
while (true) {
	if (!paused){
	for (Ball ball: balls) {
		if ((ball.x + ball.direction>= 380)||(ball.x + ball.direction <= 20)){
			ball.direction = -ball.direction;
		}
		ball.x += ball.direction;
	
	}
// 5. KORAK: premik in odboj žogic (NAMIG: ball.x += ball.direction)
GUI.repaint();
Thread.sleep(25);
}
}
}
}
class Ball {
// 1. KORAK: definicija razreda Ball (NAMIG: int x, y, direction)
	public int direction;
	public int y;
	public int x;
	Ball(int x, int y, int direction) {
	this.direction = direction;
	this.x = x;
	this.y= y;
	}
}