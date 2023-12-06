package hw14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JFrame;

public class EchoClient {
    public static void main(String[] args) {
        // final JFrame frame = new ClientFrame();
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame.setVisible(true);

        try (Socket socket = new Socket("localhost", 8189);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            System.out.println("Connected to the server.");
            System.out.println("Server Address: " + socket.getInetAddress() + ", Port: " + socket.getPort());
            System.out.println("Local Address: " + socket.getLocalAddress().getHostAddress() + ", Local Port: " + socket.getLocalPort());

            Scanner scanner = new Scanner(System.in);
            String userInput;
            
            String chatInfo = in.readLine();
            System.out.println(chatInfo);

            do {
                // Read user input
                // System.out.print("Enter a message (type BYE to exit): ");
                userInput = scanner.nextLine();

                // Send user input to the server
                out.println(userInput);

                // Receive and print the server's response
                String serverResponse = in.readLine();
                if (serverResponse == null) break;
                System.out.println("Receive: " + serverResponse);

            } while (!userInput.equalsIgnoreCase("BYE"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
