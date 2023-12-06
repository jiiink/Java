package hw14;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
    public static void main(String[] args) {
        try {
            ServerSocket s = new ServerSocket(8189);
            // Creates a server socket, bound to the specified port.
            // should avoid the conflict with the well-known ports
            // ServerSocket wait for a connection from a client at 8189
            System.out.printf("Waiting client at port %s%n", s.getLocalPort());
            Socket incoming = s.accept();
            // Listens for a connection to be made to this socket and accepts it.
            // This method blocks the current thread until the connection is made

            InetAddress clientAddress = incoming.getInetAddress();
            System.out.printf("Connected from %s[%s]\n",
                clientAddress.getHostName(), clientAddress.getHostAddress());

            try {
                InputStream inStream = incoming.getInputStream();
                OutputStream outStream = incoming.getOutputStream();

                Scanner in = new Scanner(inStream);
                PrintWriter out = new PrintWriter(outStream, true /* autoFlush */);

                out.println("Enter a message (type BYE to exit): ");
                // echo client input
                // boolean done = false;
                while (in.hasNextLine()) {
                    String line = in.nextLine(); // read a line of text from the client
                    if (line.trim().equals("BYE")) {
                        break;
                    }
                    System.out.println("Read: " + line);
                    System.out.println("Write: Hi! " + line);
                    out.println("Hi! " + line); // echo it back to the client
                    // if (line.trim().equals("BYE")) done = true;
                }
                in.close();
            } finally {
                System.out.println("Disconnected");
                incoming.close();
                s.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
