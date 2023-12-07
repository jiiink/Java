package hw14;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;

class ServerFrame extends JFrame {
    private TextPanel textPanel;

    public ServerFrame() {
        final int DEFAULT_HEIGHT = 350;
        final int DEFAULT_WIDTH = 550;
        setTitle("Echo Server");
        setSize(DEFAULT_HEIGHT, DEFAULT_WIDTH);

        textPanel = new TextPanel();
        add(textPanel, BorderLayout.CENTER);

        SwingUtilities.invokeLater(() -> {
            new ServerWorker().execute();
        });
    }

    private class ServerWorker extends SwingWorker<Void, String> {
        @Override
        protected Void doInBackground() {
            try (ServerSocket serverSocket = new ServerSocket(8189)) {
                while (!isCancelled()) {
                    Socket incoming = serverSocket.accept();
                    InetAddress clientAddress = incoming.getInetAddress();
                    textPanel.appendText("Connected from " + clientAddress.getHostAddress());
                    handleClient(incoming);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        private void handleClient(final Socket socket) {
            try {
                try (final InputStream inStream = socket.getInputStream();
                     final OutputStream outStream = socket.getOutputStream();
                     final Scanner in = new Scanner(inStream);
                     final PrintWriter out = new PrintWriter(outStream, true /* autoFlush */)) {

                    while (in.hasNextLine()) {
                        final String line = in.nextLine();
                        textPanel.appendText("Read: " + line);
                        textPanel.appendText("Write: Hi! " + line);
                        out.println("Hi! " + line);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                textPanel.appendText("Disconnected");
            }
        }
    }
}
