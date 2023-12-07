package hw14;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class EchoServer {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            final JFrame frame = new ServerFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);  
        });
    }
}
