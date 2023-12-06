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
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

class ClientFrame extends JFrame {
    private boolean isConnected = false;
    private TextPanel textPanel;
    private JTextField inputField;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public ClientFrame() {
        // TextPanel textPanel;
	    final int DEFAULT_WIDTH = 550;
	    final int DEFAULT_HEIGHT = 350; 
        setTitle("Echo Client");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        // menu is not needed

        textPanel = new TextPanel(); add(textPanel, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();

        addButton(buttonPanel, "Connect", (ActionEvent event) -> {
            if (!isConnected) {
                connectToServer();
            } else {
                textPanel.appendText("Already connected!");
            }
        });
        addButton(buttonPanel, "Disconnect", (ActionEvent event) -> {
            // Add logic for Disconnect button
            if (isConnected) {
                disconnectFromServer();
            } else {
                textPanel.appendText("Not connected!");
            }
        });

        // Add input field for typing messages
        inputField = new JTextField();
        inputField.setColumns(5); // set the preferred number of columns
        buttonPanel.add(inputField);

        // text insert
        addButton(buttonPanel, "Send", (ActionEvent event) -> {
            // Add logic for Send button
            // textPanel.setText("Text sent!"); // Example text, replace with your logic
            if (isConnected) {
                sendMessage(inputField.getText());
            } else {
                textPanel.appendText("Not Connected!");
            }
        });
        addButton(buttonPanel, "Clear", (ActionEvent event) -> {
            // Add logic for Clear button
            // textPanel.setText(""); // Clear the text
            textPanel.clearText();
        });
        addButton(buttonPanel, "Quit", (ActionEvent event) -> System.exit(0));

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void addButton(Container container, String title, ActionListener listener) {
        JButton button = new JButton(title);
        container.add(button);
        button.addActionListener(listener);
    }

    private void connectToServer() {
        try {
            if (socket != null && !socket.isClosed()) {
                // Close the previous socket before attempting to create a new connection
                socket.close();
            }
            socket = new Socket("localhost", 8189);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);
            
            isConnected = true;
            textPanel.appendText("Try to connect " + socket.getLocalAddress().getHostAddress());
            textPanel.appendText("Connection Established");

            // Start a thread to continuously listen for server messages
            new Thread(() -> {
                try {
                    while (isConnected) {
                        // String userInput = scanner.nextLine();
                        // textPanel.setText("Send: " + userInput);
                        // out.println(userInput);
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

    private void sendMessage(String message) {
        out.println(message);
        textPanel.appendText("Send: " + message);
        inputField.setText("");
    }
}
