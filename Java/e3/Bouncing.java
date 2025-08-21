import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Bouncing extends JFrame {

	static final int NUMBER = 10;
	
	static final int SIZE = 40;
	
	List<Ball> balls = new ArrayList<Ball>();
	
	boolean running = true;

	public Bouncing() {
		super("Bouncing");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel() {
			@Override
			public void paint(Graphics g) {
				super.paint(g);
				
				g.setColor(Color.BLACK);
				for (Ball ball: balls)
					g.fillOval(ball.x - SIZE / 2, ball.y - SIZE / 2, SIZE, SIZE);
			}
		};
		panel.setPreferredSize(new Dimension(400, 800));
		panel.setBackground(Color.WHITE);
		panel.setFocusable(true);
		add(panel);
		pack();
		
		panel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				running = !running;
				repaint();
			}
		});
		
		for (int i = 0; i < NUMBER; i++)
			balls.add(new Ball(panel.getWidth() / 2, (int)Math.round((i + 1.0) * panel.getHeight() / (NUMBER + 1)), i + 11));
	}

	public static void main(String[] args) throws InterruptedException {
		Bouncing GUI = new Bouncing();
		GUI.setVisible(true);

		while (true) {
			if (GUI.running) {
				for (Ball ball: GUI.balls) {
					ball.x += ball.direction;

					if (ball.x < SIZE / 2) {
						ball.x = SIZE - ball.x;
						ball.direction *= -1;
					}
					else if (ball.x > GUI.getWidth() - SIZE / 2) {
						ball.x = 2 * GUI.getWidth() - SIZE - ball.x;
						ball.direction *= -1;
					}
				}

				GUI.repaint();
			}
			
			Thread.sleep(25);
		}
	}

}

class Ball {
	
	int x;
	
	int y;
	
	int direction;
	
	public Ball(int x, int y, int direction) {
		super();
		this.x = x;
		this.y = y;
		this.direction = direction;
	}
	
}
