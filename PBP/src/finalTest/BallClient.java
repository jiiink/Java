package finalTest;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class BallClient {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            final JFrame frame = new ClientFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

