package hw12;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

class BounceFrame extends JFrame {
	public BounceFrame() {
		setTitle("BounceThread");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		
		JMenu speedMenu = new JMenu("Speed");
		JMenuItem fasterItem = speedMenu.add(new SpeedAction("Faster"));
		JMenuItem slowerItem = speedMenu.add(new SpeedAction("Slower"));
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.add(speedMenu);

		
		
		ballPanel = new BallPanel(); add(ballPanel, BorderLayout.CENTER);
		JPanel buttonPanel = new JPanel();

		addButton(buttonPanel, "Add 1", (ActionEvent event) -> addBall());
		addButton(buttonPanel, "Add 2", (ActionEvent event) -> {
			addBall();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			addBall();
		});

		addButton(buttonPanel, "Close", (ActionEvent event) -> System.exit(0));
		add(buttonPanel, BorderLayout.SOUTH);
	}
	private void addButton(Container container, String title, ActionListener listener) {
		JButton button = new JButton(title);
		container.add(button);
		button.addActionListener(listener);
	}	
		/**
		Adds a bouncing ball to the canvas and starts a thread to make it bounce
		*/
	public void addBall() {
		Ball b = new Ball(ballSpeed);
		ballPanel.add(b);
		Runnable r = new BallRunnable(b, ballPanel);
		Thread t = new Thread(r);
		t.start();
	}
	private BallPanel ballPanel;
	public static final int DEFAULT_WIDTH = 450;
	public static final int DEFAULT_HEIGHT = 350; 
	
	private static double ballSpeed = 1;
	public static void setBallSpeed(double ratio) {
		ballSpeed *= ratio;
	}
}

