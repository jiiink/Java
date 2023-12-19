package finalTest;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
// import javax.swing.JOptionPane;

class SpeedAction extends AbstractAction { 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public SpeedAction(final String name) { 
		super(name); 
	}
	
	public void actionPerformed(final ActionEvent event) {
		if (getValue(Action.NAME).equals("Faster")) {
			ServerFrame.setBallSpeed(2.0);
		} else {
			ServerFrame.setBallSpeed(0.5);
		}
	}
}

