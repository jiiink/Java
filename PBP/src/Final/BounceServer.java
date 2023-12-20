package Final;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class BounceServer {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            final JFrame frame = new ServerFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class ServerFrame extends JFrame {
    private final BallPanel ballPanel;
    private static double ballSpeed = 1;
    private static double ballSize = 1;
    private JTextField countField;
    private JTextField numberField;
    
    public ServerFrame() {
        setTitle("Ball Bounce Server");
        setSize(450, 350);
        ballPanel = new BallPanel(); add(ballPanel, BorderLayout.CENTER);
        // countField = new JTextField();
        // countField.setColumns(3);
        // buttonPanel.add(countField);
        // numberField = new JTextField();
        // numberField.setColumns(3);
        // buttonPanel.add(numberField);
        // add(buttonPanel, BorderLayout.SOUTH);
        final JPanel buttonPanel = new JPanel();
                        // addButton(buttonPanel, "Count", (ActionEvent e) -> {
                        //         // sendMessage("Add " + countField.getText());
                        //     });
                        //     addButton(buttonPanel, "개", (ActionEvent e) -> {
                        //         // sendMessage("Add " + countField.getText());
                        //     });
                            add(buttonPanel, BorderLayout.SOUTH);
        
        SwingUtilities.invokeLater(() -> {
            new ServerWorker().execute();
        });
    }

    public void addButton(Container c, String title, ActionListener l) {
        JButton button = new JButton(title);
        c.add(button);
        button.addActionListener(l);
    }

    public void addBall() {
        final Ball b = new Ball (ballSpeed, ballSize);
        ballPanel.add(b);
        final Runnable r = new BallRunnable(b, ballPanel);
        final Thread t = new Thread(r); t.start();
    }
    public void removeBall() {
        // final Ball b = new Ball (ballSpeed, ballSize);
        ballPanel.remove();
        // final Runnable r = new BallRunnable(b, ballPanel);
        // final Thread t = new Thread(r); t.start();
    }
    public void removeAllBalls() {
        ballPanel.removeAllBalls();
    }

    private class ServerWorker extends SwingWorker<Void, String> {
        @Override
        protected Void doInBackground() {
            try (ServerSocket serverSocket = new ServerSocket(8189)) {
                while (!isCancelled()) {
                    Socket incoming = serverSocket.accept();
                    InetAddress clInetAddress = incoming.getInetAddress();
                    handleClient(incoming);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        private void handleClient(final Socket socket) throws IOException {
            try {
                try (final InputStream inStream = socket.getInputStream();
                    final OutputStream outStream = socket.getOutputStream();
                    final Scanner in = new Scanner(inStream);
                    final PrintWriter out = new PrintWriter(outStream, true)) {
                        
                        while (in.hasNextLine()) {
                            
                            // numberField.setText("개");
                            final String line = in.nextLine();
                            // System.out.println(line.split(" ")[0]);
                            // System.out.println(line.split(" ")[1]);
                            if (line.split(" ")[0].equals("Add")) {
                                int count = Integer.valueOf(line.split(" ")[1]);
                                // addBall();
                                // try {
                                //     Thread.sleep(1000);
                                // } catch (InterruptedException e) {
                                //     e.printStackTrace();
                                // }
                                // addBall();
                                for (int i=0; i<count; i++) {
                                    addBall();
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                                // System.out.println(count);
                            } else if (line.split(" ")[0].equals("Remove")) {
                                // System.out.println("remove");
                                // if (line.split(" ")[1].)
                                int count = Integer.valueOf(line.split(" ")[1]);
                                // removeBall();
                                for (int i=0; i<count; i++) {
                                    removeBall();
                                    
                                }
                            } else if (line.split(" ")[0].equals("RemoveAll")) {
                                removeAllBalls();
                                for (int i=0; i<1; i++) {}
                            }
                        }
                    }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                // socket.close();
                System.exit(0);
            }
        }
    }
}


class Ball {
    public Ball (final double speed, final double size) {
        this.dx = speed;
        this.dy = speed;
        this.XSIZE *= size;
        this.YSIZE *= size;
    }
    public void move(Rectangle2D bounds) {
        x += dx; y += dy;
        if (x < bounds.getMinX()) {
            x = bounds.getMinX();
            dx = -dx;
        }
        if (x + XSIZE >= bounds.getMaxX()) {
            x = bounds.getMaxX() - XSIZE;
            dx = -dx;
        }
        if (y < bounds.getMinY()) {
            y = bounds.getMinY();
            dy = -dy;
        }
        if (y + YSIZE >= bounds.getMaxY()) {
            y = bounds.getMaxY() - YSIZE;
            dy = -dy;
        }
    }

    public Ellipse2D getShape() {
        return new Ellipse2D.Double(x, y, XSIZE, YSIZE);
    }
    private double XSIZE = 15;
    private double YSIZE = 15;
    private double x = 0;
    private double y = 0;
    private double dx = 1;
    private double dy = 1;
}

class BallPanel extends JPanel {
    public void add(final Ball b) {
        balls.add(b);
    }
    public void remove() {
        balls.remove(balls.size()-1);
    }
    public void removeAllBalls() {
        for (int i=0; i<balls.size(); i++) {
            balls.remove(i);
        }
        balls.remove(balls.size()-1);
    }
    public void paintComponent(final Graphics g) {
        super.paintComponent(g);
        final Graphics2D g2 = (Graphics2D) g;
        for (final Ball b : balls) {
            g2.fill(b.getShape());
        }
    }

    private List<Ball> balls = new ArrayList<>();
}

class BallRunnable implements Runnable {
    public BallRunnable(final Ball aBall, final JPanel ballPanel) {
        ball = aBall; this.ballPanel = ballPanel;
    }

    @Override
    public void run() {
        try {
            for (int i=1; i<STEPS; i++) {
                ball.move(ballPanel.getBounds());
                SwingUtilities.invokeLater(() -> ballPanel.repaint());
                Thread.sleep(DELAY);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private final Ball ball;
    private final JPanel ballPanel;
    public static final int STEPS = 10000;
    public static final int DELAY = 3;
}