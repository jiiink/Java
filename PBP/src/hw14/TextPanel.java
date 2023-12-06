package hw14;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class TextPanel extends JPanel {
    private JTextArea textArea;
    private List<String> texts = new ArrayList<>();
    public TextPanel() {
        setLayout(new BorderLayout());
        textArea = new JTextArea();
        textArea.setEditable(false); // Set to true if you want it to be editable
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    // Method to set the text in the JTextArea
    public void appendText(String text) {
        texts.add(text);
        String msg = "";
        for (String t : texts) {
            msg += t + '\n';
        }
        textArea.setText(msg);
        // textArea.setText(texts);
    }
    // Method to clear the textArea
    public void clearText() {
        textArea.setText("");
        texts.removeAll(texts);
    }
}
