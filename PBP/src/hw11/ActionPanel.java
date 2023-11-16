package hw11;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JPanel;

class ActionPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ActionPanel() { 
		final Action AddAction = 
				new MyButtonAction("Add");
		final Action RemoveFirstAction = 
				new MyButtonAction("Remove First");
		final Action RemoveLastAction = 
				new MyButtonAction("Remove Last");
		final Action RemoveAllAction = 
				new MyButtonAction("Remove All");
		final Action QuitAction = 
				new MyButtonAction("Quit");

		final JButton AddButton = new JButton(AddAction);
		add(AddButton);
		final JButton RemoveFirstButton = new JButton(RemoveFirstAction);
		add(RemoveFirstButton);
		final JButton RemoveLastButton = new JButton(RemoveLastAction);
		add(RemoveLastButton);
		final JButton RemoveAllButton = new JButton(RemoveAllAction);
		add(RemoveAllButton);
		final JButton QuitButton = new JButton(QuitAction);
		QuitButton.addActionListener((event) -> System.exit(0));
		add(QuitButton);
	}
}

