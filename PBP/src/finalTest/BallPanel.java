package finalTest;

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
	 * 
	 */
	private static final long serialVersionUID = 1L;
/**
Add a ball to the panel.
@param b the ball to add
*/
	public void add(final Ball b) {
		balls.add(b);
	}
	public void paintComponent (final Graphics g) {
		super.paintComponent(g);
		final Graphics2D g2 = (Graphics2D) g;
		for (final Ball b : balls) { g2.fill(b.getShape()); }
	}
	private List<Ball> balls = new ArrayList<>();
}

