package hw14;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

class ClientFrame extends JFrame {
    private boolean isConnected = false;
    final private TextPanel textPanel;
    final private JTextField inputField;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public ClientFrame() {
	    final int DEFAULT_WIDTH = 550;
	    final int DEFAULT_HEIGHT = 350; 
        setTitle("Echo Client");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        textPanel = new TextPanel(); 
        add(textPanel, BorderLayout.CENTER);
        final JPanel buttonPanel = new JPanel();

        addButton(buttonPanel, "Connect", (final ActionEvent event) -> {
            if (!isConnected) {
                connectToServer();
            } else {
                textPanel.appendText("Already connected!");
            }
        });
        addButton(buttonPanel, "Disconnect", (final ActionEvent event) -> {
            if (isConnected) {
                disconnectFromServer();
            } else {
                textPanel.appendText("Not connected!");
            }
        });

        inputField = new JTextField();
        inputField.setColumns(5);
        buttonPanel.add(inputField);

        addButton(buttonPanel, "Send", (final ActionEvent event) -> {
            if (isConnected) {
                sendMessage(inputField.getText());
            } else {
                textPanel.appendText("Not Connected!");
            }
        });
        addButton(buttonPanel, "Clear", (final ActionEvent event) -> {
            textPanel.clearText();
        });
        addButton(buttonPanel, "Quit", (final ActionEvent event) -> System.exit(0));

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void addButton(final Container container, final String title, final ActionListener listener) {
        final JButton button = new JButton(title);
        container.add(button);
        button.addActionListener(listener);
    }

    private void connectToServer() {
        try {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
            socket = new Socket("localhost", 8189);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        
            isConnected = true;
            textPanel.appendText("Try to connect " + socket.getLocalAddress().getHostAddress());
            textPanel.appendText("Connection Established");

            new Thread(() -> {
                try {
                    while (isConnected) {
                        String serverResponse = in.readLine();
                        if (serverResponse == null) {
                            break;
                        }
                        textPanel.appendText("Receive: " + serverResponse);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void disconnectFromServer() {
        try {
            isConnected = false;
            textPanel.appendText("Disconnected from the server.");
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage(final String message) {
        out.println(message);
        textPanel.appendText("Send: " + message);
        inputField.setText("");
    }
}
