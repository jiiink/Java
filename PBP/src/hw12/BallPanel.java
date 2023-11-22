package hw12;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

/**
The panel that draws the balls.
*/
class BallPanel extends JPanel {
/**
Add a ball to the panel.
@param b the ball to add
*/
	public void add(Ball b) {
		balls.add(b);
	}
	public void paintComponent (Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		for (Ball b : balls) { g2.fill(b.getShape()); }
	}
	private List<Ball> balls = new ArrayList<>();
}

