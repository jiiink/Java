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




class ActionPanel extends JPanel {
	class MyButtonAction extends AbstractAction {
		//AbstractAction implements all methods of interface Action except for actionPerformed
		public MyButtonAction(String name) { 
			putValue(Action.NAME, name); // displayed on buttons and menu items
//			putValue(Action.SMALL_ICON, icon);
			putValue(Action.SHORT_DESCRIPTION, // for display in a tooltip
					"Help for button " + name.toLowerCase());
//			putValue("color", c);
		}
		@Override
		public void actionPerformed(ActionEvent event) { 
			setBackground((Color) getValue("color"));
		}
	} 
	public ActionPanel() { 
		Action yellowAction = // name, icon, color
				new ColorAction("Yellow", new ImageIcon("yellow-ball.gif"), Color.YELLOW);
		Action blueAction =
				new ColorAction("Blue", new ImageIcon("blue-ball.gif"), Color.BLUE);
		Action redAction =
				new ColorAction("Red", new ImageIcon("red-ball.gif"), Color.RED);

		//add buttons for these actions to the panel 
		add(new JButton(yellowAction));
		add(new JButton(blueAction));
		add(new JButton(redAction));
		//javax.swing.InputMap and javax.swing.ActionMap
		InputMap imap = getInputMap(JComponent.WHEN_FOCUSED);
		imap.put(KeyStroke.getKeyStroke("ctrl Y"), "panel.yellow");
		imap.put(KeyStroke.getKeyStroke("ctrl B"), "panel.blue");
		imap.put(KeyStroke.getKeyStroke("ctrl R"), "panel.red");
		//void put(KeyStroke keyStroke, Object actionMapKey)
		//Adds a binding for keyStroke to actionMapKey.
		//ActionMap provides mappings from Objects (called keys or Action names) to Actions
		ActionMap amap = getActionMap();
		amap.put("panel.yellow", yellowAction);
		amap.put("panel.blue", blueAction);
		amap.put("panel.red", redAction);
		//put(Object key, Action action): Adds a binding for key to action.
	}
}
