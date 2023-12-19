package finalTest;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;

class ServerFrame extends JFrame {
    private final BallPanel ballPanel;
	public static final int DEFAULT_WIDTH = 450;
	public static final int DEFAULT_HEIGHT = 350; 
	
	private static double ballSpeed = 1;
	private static double ballSize = 1;

    public ServerFrame() {
        setTitle("Ball Server");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        ballPanel = new BallPanel(); add(ballPanel, BorderLayout.CENTER);

        SwingUtilities.invokeLater(() -> {
            new ServerWorker().execute();
        });
    }

    public void addBall() {
		final Ball b = new Ball(ballSpeed, ballSize);
		ballPanel.add(b);
		final Runnable r = new BallRunnable(b, ballPanel);
		final Thread t = new Thread(r);
		t.start();
	}

    private class ServerWorker extends SwingWorker<Void, String> {
        @Override
        protected Void doInBackground() {
            try (ServerSocket serverSocket = new ServerSocket(8189)) {
                while (!isCancelled()) {
                    Socket incoming = serverSocket.accept();
                    InetAddress clientAddress = incoming.getInetAddress();
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
                        if (line.equals("Add 1")) {
                            addBall();
                        } else if (line.equals("Add 2")) {
                            addBall();
                            try {
                                Thread.sleep(100);
                            } catch (final InterruptedException e) {
                                e.printStackTrace();
                            }
                            addBall();
                        } else if (line.equals("Faster")) {
                            new SpeedAction(line).actionPerformed(null);
                        } else if (line.equals("Slower")) {
                            new SpeedAction(line).actionPerformed(null);
                        } else if (line.equals("Bigger")) {
                            new SizeAction(line).actionPerformed(null);
                        } else if (line.equals("Smaller")) {
                            new SizeAction(line).actionPerformed(null);
                        }

                        out.println(line + " changed");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                // textPanel.appendText("Disconnected");
            }
        }
    }

    public static void setBallSpeed(double ratio) {
		ballSpeed *= ratio;
	}
	public static void setBallSize(double ratio) {
		ballSize *= ratio;
	}
}
