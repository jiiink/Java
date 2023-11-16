package hw11;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;

class MyButtonAction extends AbstractAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public MyButtonAction(final String name) {
		putValue(Action.NAME, name);
		putValue(Action.SHORT_DESCRIPTION,
				"Help for button " + name.toLowerCase());
	}
	@Override
	public void actionPerformed(final ActionEvent event) {
		final String cmd = event.getActionCommand();
		JOptionPane.showMessageDialog(null, cmd);
	}
} 