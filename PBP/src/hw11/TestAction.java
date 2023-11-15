package hw11;

import java.awt.event.*;
class FrameWithButtonActionListener extends JFrame implements ActionListener {
public FrameWithButtonActionListener (String title) {
setTitle(title) ; setVisible(true); setSize(400, 150) ;
JPanel panel = new JPanel() ;
add(panel) ;
JButton button1 = new JButton("click me1");
button1.addActionListener(this) ;
panel.add(button1);
JButton button2 = new JButton("click me2");
button2.addActionListener(this) ;
panel.add(button2);
}
@Override
public void actionPerformed(ActionEvent event) {
System.out.println(event) ;
String cmd = event.getActionCommand() ;
//String cmd = ((JButton) event.getSource()).getText() ;
JOptionPane.showMessageDialog(null, cmd) ;
}
}