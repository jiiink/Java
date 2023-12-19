package finalTest;

import java.awt.BorderLayout;
import java.awt.Container;
// import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.Action;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

class ClientFrame extends JFrame {
    private boolean isConnected = false;
    final private TextPanel textPanel;
    // final private JTextField inputField;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public ClientFrame() {
	    final int DEFAULT_WIDTH = 550;
	    final int DEFAULT_HEIGHT = 350; 
        setTitle("Ball Client");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);


        final JMenu speedMenu = new JMenu("Speed");
		final JMenuItem fasterItem = speedMenu.add("Faster");
        fasterItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage("Faster");
            }
        });
        final JMenuItem slowerItem = speedMenu.add("Slower");
        slowerItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage("Slower");
            }
        });

		final JMenu sizeMenu = new JMenu("Size");
		final JMenuItem biggerItem = sizeMenu.add("Bigger");
        biggerItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage("Bigger");
            }
        });
		final JMenuItem smallerItem = sizeMenu.add("Smaller");
		smallerItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage("Smaller");
            }
        });
		final JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.add(speedMenu);
		menuBar.add(sizeMenu);
		// end menu
		

        textPanel = new TextPanel(); 
        add(textPanel, BorderLayout.CENTER);
        
		final JPanel buttonPanel = new JPanel();

        addButton(buttonPanel, "Add 1", (final ActionEvent event) -> {
            sendMessage("Add 1");
        });
        addButton(buttonPanel, "Add 2", (final ActionEvent event) -> {
            sendMessage("Add 2");
        });

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
                        textPanel.appendText(serverResponse);
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
        textPanel.appendText(message);
        // inputField.setText("");
    }
}


