package Practice.Network;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class DayTimeClient {
    public static void main(String[] args) throws InterruptedException {
        try { // Creates a strean socket and connects it to the port on the host.
            Socket socket = new Socket("time-A.timefreq.bldrdoc.gov", 13);
            // Socket(String host, int port) throws UnknownHostException, IOException
            System.out.println(socket.getInetAddress() + " " + socket.getPort());
            System.out.println(socket.getLocalAddress().getHostAddress() + " " + socket.getLocalPort());

            // Thread.sleep(1000);

            try (Scanner in = new Scanner(socket.getInputStream())) {
                while (in.hasNextLine()) {
                    String line = in.nextLine();
                    System.out.println(line);
                }
            }
            finally {socket.close();}
        } catch (IOException e) {e.printStackTrace();}
        // UnknownHostException is a subclass of IOException
    }
}
