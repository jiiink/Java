package hw12;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;

class SpeedAction extends AbstractAction { 
	public SpeedAction(String name) { super(name); }
	public void actionPerformed(ActionEvent event) {
//		JOptionPane.showMessageDialog(null, getValue(Action.NAME) + " selected.");
		if (getValue(Action.NAME).equals("Faster")) {
			//Ball.setSpeed(2.0);	
			BallRunnable.speed *= 2;
		} else {
			BallRunnable.speed *= 0.5;
		}
	}
}

