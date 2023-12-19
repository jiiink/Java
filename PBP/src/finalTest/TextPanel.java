package finalTest;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class TextPanel extends JPanel {
    final private JTextArea textArea;
    private List<String> texts = new ArrayList<>();
    public TextPanel() {
        setLayout(new BorderLayout());
        textArea = new JTextArea();
        textArea.setEditable(false);
        final JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    // Method to set the text in the JTextArea
    public void appendText(final String text) {
        texts.add(text);
        String msg = texts.stream()
            .collect(Collectors.joining("\n"));
        textArea.setText(msg);
    }
    // Method to clear the textArea
    public void clearText() {
        textArea.setText("");
        texts.removeAll(texts);
    }
}
