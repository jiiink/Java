package finalTest;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
A runnable that animates a bouncing ball.
*/
class BallRunnable implements Runnable {
	public BallRunnable(final Ball aBall, final JPanel ballPanel) { 
		ball = aBall; this.ballPanel = ballPanel;
	}
	
	public void run() {
        try {
            for (int i = 1; i <= STEPS; i++) {
                ball.move(ballPanel.getBounds());
                SwingUtilities.invokeLater(() -> ballPanel.repaint()); // Use invokeLater to update the UI on the Event Dispatch Thread
                Thread.sleep(DELAY);
            }
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }
    }
	
	private final Ball ball;
	private final JPanel ballPanel;
	public static final int STEPS = 10000;
	public static final int DELAY = 3;
}
