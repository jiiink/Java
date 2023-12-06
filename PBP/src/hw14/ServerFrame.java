package hw14;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class ServerFrame extends JFrame {
    private TextPanel textPanel;

    public ServerFrame() {
        final int DEFAULT_HEIGHT = 350;
        final int DEFAULT_WIDTH = 550;
        setTitle("Echo Server");
        setSize(DEFAULT_HEIGHT, DEFAULT_WIDTH);

        textPanel = new TextPanel();
        add(textPanel, BorderLayout.CENTER);

        // Initialize Swing components on the EDT
        SwingUtilities.invokeLater(() -> {
            new ServerWorker().execute();
        });
    }

    private class ServerWorker extends SwingWorker<Void, String> {
        @Override
        protected Void doInBackground() {
            try (ServerSocket serverSocket = new ServerSocket(8189)) {
                System.out.printf("Server is running at port %s%n", serverSocket.getLocalPort());

                while (!isCancelled()) {
                    Socket incoming = serverSocket.accept();
                    InetAddress clientAddress = incoming.getInetAddress();
                    System.out.printf("Connected from %s[%s]%n",
                            clientAddress.getHostName(), clientAddress.getHostAddress());
                    textPanel.appendText("Connected from " + 
                            clientAddress.getHostAddress());
                    publish("Connected from " + clientAddress.getHostAddress());

                    handleClient(incoming);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void process(List<String> chunks) {
            for (String message : chunks) {
                textPanel.appendText(message + "\n");
            }
        }

        private void handleClient(Socket socket) {
            try {
                try (InputStream inStream = socket.getInputStream();
                     OutputStream outStream = socket.getOutputStream();
                     Scanner in = new Scanner(inStream);
                     PrintWriter out = new PrintWriter(outStream, true /* autoFlush */)) {

                    while (in.hasNextLine()) {
                        String line = in.nextLine();
                        if (line.trim().equals("BYE")) {
                            break;
                        }
                        System.out.println("Read: " + line);
                        textPanel.appendText("Read: " + line);
                        publish("Read: " + line);
                        System.out.println("Write: Hi! " + line);
                        textPanel.appendText("Write: Hi! " + line);
                        publish("Write: Hi! " + line);
                        out.println("Hi! " + line);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                System.out.println("Client disconnected");
                textPanel.appendText("Disconnected");
                publish("Disconnected");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new ServerFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
