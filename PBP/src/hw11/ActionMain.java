package hw11;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ActionMain { 
	public static void main(String[] args) { 
		ActionFrame frame = new ActionFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

class ActionFrame extends JFrame {
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	public ActionFrame() {
		setTitle("ActionTest");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		ActionPanel panel = new ActionPanel();
		add(panel);
	}
}




class ActionPanel extends JPanel implements ActionListener{
	class MyButtonAction extends AbstractAction {
		public MyButtonAction(String name) { 
			putValue(Action.NAME, name); // displayed on buttons and menu items
			putValue(Action.SHORT_DESCRIPTION, // for display in a tooltip
					"Help for button " + name.toLowerCase());
		}
		
		@Override
		public void actionPerformed(ActionEvent event) { 
			setBackground((Color) getValue("color"));
		}
	} 
	
	public ActionPanel() { 
		Action AddAction = 
				new MyButtonAction("Add");
		Action RemoveFirstAction = 
				new MyButtonAction("Remove First");
		Action RemoveLastAction = 
				new MyButtonAction("Remove Last");
		Action RemoveAllAction = 
				new MyButtonAction("Remove All");
		Action QuitAction = 
				new MyButtonAction("Quit");

		
		
		//add buttons for these actions to the panel 
		JButton AddButton = new JButton(AddAction);
		AddButton.addActionListener(this);
		add(AddButton);
		JButton RemoveFirstButton = new JButton(RemoveFirstAction);
		RemoveFirstButton.addActionListener(this);
		add(RemoveFirstButton);
		JButton RemoveLastButton = new JButton(RemoveLastAction);
		RemoveLastButton.addActionListener(this);
		add(RemoveLastButton);
		JButton RemoveAllButton = new JButton(RemoveAllAction);
		RemoveAllButton.addActionListener(this);
		add(RemoveAllButton);
		JButton QuitButton = new JButton(QuitAction);
		QuitButton.addActionListener((event) -> System.exit(0));
		add(QuitButton);
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		System.out.println(event) ;
		String cmd = event.getActionCommand() ;
		//String cmd = ((JButton) event.getSource()).getText() ;
		JOptionPane.showMessageDialog(null, cmd) ;
	}
}
