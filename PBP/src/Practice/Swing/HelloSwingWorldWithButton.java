package Practice.Swing;

import javax.swing.*;
public class HelloSwingWorldWithButton {
public static void main(String[] args) {
JFrame frame = new JFrame("SimpleFrameWithButton");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);
frame.setSize(400, 150) ;
JButton button = new JButton("click me");
frame.add(button);
}
}