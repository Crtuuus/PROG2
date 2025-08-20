package alien;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Alien extends JFrame {

	static final int SIZE = 15;

	static final int PIXELS = 50;

	static BufferedImage ALIEN = null;
	
	boolean[][] blocks = new boolean[SIZE][SIZE];

	Point alien = new Point(0, 0);

	public Alien() throws Exception {
		super("Alien");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ALIEN = ImageIO.read(new URL("https://lovro.fri.uni-lj.si/pro2/exams/alien.png"));

		JPanel panel = new JPanel() {
			@Override
			public void paint(Graphics g) {
				super.paint(g);

				g.drawImage(ALIEN, alien.x * PIXELS, alien.y * PIXELS, PIXELS, PIXELS, null);

				g.setColor(Color.GRAY);
				for (int i = 0; i < SIZE; i++)
					for (int j = 0; j < SIZE; j++)
						if (blocks[i][j])
							g.fillRect(j * PIXELS, i * PIXELS, PIXELS, PIXELS);

				g.setColor(Color.LIGHT_GRAY);
				for (int i = 1; i < SIZE; i++) {
					g.drawLine(i * PIXELS, 0, i * PIXELS, SIZE * PIXELS);
					g.drawLine(0, i * PIXELS, SIZE * PIXELS, i * PIXELS);
				}
			}
		};
		panel.setPreferredSize(new Dimension(SIZE * PIXELS, SIZE * PIXELS));
		panel.setBackground(Color.WHITE);
		panel.setFocusable(true);
		add(panel);
		pack();

		panel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_RIGHT:
					if (alien.x < SIZE - 1 && !blocks[alien.y][alien.x + 1])
						alien.x++;
					break;
				case KeyEvent.VK_LEFT:
					if (alien.x > 0 && !blocks[alien.y][alien.x - 1])
						alien.x--;
					break;
				case KeyEvent.VK_DOWN:
					if (alien.y < SIZE - 1 && !blocks[alien.y + 1][alien.x])
						alien.y++;
					break;
				case KeyEvent.VK_UP:
					if (alien.y > 0 && !blocks[alien.y - 1][alien.x])
						alien.y--;
					break;
				default:
					break;
				}

				if (alien.x == SIZE - 1 && alien.y == SIZE - 1)
					System.exit(0);
				else
					repaint();
			}
		});
		
		for (int i = 0; i < SIZE; i++)
			for (int j = 0; j < SIZE; j++)
				if ((i > 0 || j > 0) && (i < SIZE - 1 || j < SIZE - 1))
					blocks[i][j] = Math.random() < 0.30;
	}

	public static void main(String[] args) throws Exception {
		new Alien().setVisible(true);
	}

}
