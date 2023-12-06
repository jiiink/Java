package hw14;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

class ClientFrame extends JFrame {
    public ClientFrame() {
        TextPanel textPanel;
	    final int DEFAULT_WIDTH = 450;
	    final int DEFAULT_HEIGHT = 350; 
        setTitle("EchoClient");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        // menu is not needed

        textPanel = new TextPanel(); add(textPanel, BorderLayout.CENTER);
        final JPanel buttonPanel = new JPanel();

        addButton(buttonPanel, "Connect", (ActionEvent event) -> {});
        addButton(buttonPanel, "Disconnect", (ActionEvent event) -> {});
        // text insert
        addButton(buttonPanel, "Send", (ActionEvent event) -> {});
        addButton(buttonPanel, "Clear", (ActionEvent event) -> {});
        addButton(buttonPanel, "Quit", (ActionEvent event) -> System.exit(0));

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void addButton(Container container, String title, ActionListener listener) {
        JButton button = new JButton(title);
        container.add(button);
        button.addActionListener(listener);
    }
}
