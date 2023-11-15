package hw11;

import java.awt.event.*;

import javax.swing.*;

class FrameWithButtonActionListener extends JFrame implements ActionListener {
	public FrameWithButtonActionListener (String title) {
		setTitle(title) ; setVisible(true); setSize(400, 150) ;
		JPanel panel = new JPanel() ;
		add(panel) ;
		JButton button1 = new JButton("Add");
		button1.addActionListener(this) ;
		panel.add(button1);
		JButton button2 = new JButton("Remove First");
		button2.addActionListener(this) ;
		panel.add(button2);
		JButton button3 = new JButton("Remove Last");
		button3.addActionListener(this) ;
		panel.add(button3);
		JButton button4 = new JButton("Remove All");
		button4.addActionListener(this) ;
		panel.add(button4);
		
		
		JButton button5 = new JButton("Quit");
		button5.addActionListener((event) -> System.exit(0));
		panel.add(button5);
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		System.out.println(event) ;
		String cmd = event.getActionCommand() ;
		//String cmd = ((JButton) event.getSource()).getText() ;
		JOptionPane.showMessageDialog(null, cmd) ;
	}
}
//class TestAction extends AbstractAction { 
///**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	public TestAction(String name) { super(name); }
//	public void actionPerformed(ActionEvent event) {
//		JOptionPane.showMessageDialog(null, getValue(Action.NAME) + " selected.");
//	}
//}

