package Final;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BounceClient {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            final JFrame frame = new ClientFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class ClientFrame extends JFrame {
    private boolean isConnected = false;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private JTextField countField;
    private JTextField numberField;
    public ClientFrame() {
        setTitle("Ball Bounce Client");
        setSize(450, 350);
        final JPanel buttonPanel = new JPanel();
        countField = new JTextField();
        countField.setColumns(3);
        buttonPanel.add(countField);
        addButton(buttonPanel, "Add", (ActionEvent e) -> {
            if (!isConnected) connectToServer();
            sendMessage("Add " + countField.getText());
        });
        numberField = new JTextField();
        numberField.setColumns(3);
        buttonPanel.add(numberField);
        addButton(buttonPanel, "Remove", (ActionEvent e) -> {
            sendMessage("Remove " + numberField.getText());
        });
        addButton(buttonPanel, "Remove All", (ActionEvent e) -> {
            sendMessage("RemoveAll");
        });
        addButton(buttonPanel, "Quit", (ActionEvent e) -> System.exit(0));
        add(buttonPanel, BorderLayout.SOUTH);

        
    }
    public void addButton(Container c, String title, ActionListener l) {
        JButton button = new JButton(title);
        c.add(button);
        button.addActionListener(l);
    }
    private void sendMessage(final String msg) {
        out.println(msg);
        countField.setText("");
        numberField.setText("");
    }
    private void connectToServer() {
        try {
            if (socket != null && !socket.isClosed()) socket.close();
            socket = new Socket("localhost", 8189);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            isConnected = true;
            new Thread(() -> {
                try {
                    while (isConnected) {
                        String serverResponse = in.readLine();
                        if (serverResponse == null) break;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
