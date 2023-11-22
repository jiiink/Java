package hw12;

import javax.swing.JPanel;

/**
A runnable that animates a bouncing ball.
*/
class BallRunnable implements Runnable {
	public BallRunnable(Ball aBall, JPanel ballPanel) { 
		ball = aBall; this.ballPanel = ballPanel;
	}
	public void run() {
		try {
			for (int i = 1; i <= STEPS; i++) {
				for (int j = 0; j < ball.speed; j++) {
					ball.move(ballPanel.getBounds()); // update the location of the ball
					ballPanel.paint(ballPanel.getGraphics());					
				}
				Thread.sleep(DELAY);
			}
		} catch (InterruptedException e) { }
	}
	private Ball ball;
	private JPanel ballPanel;
	public static final int STEPS = 10000;
	public static final int DELAY = 3;
	// public static int speed = 1;
	
}
