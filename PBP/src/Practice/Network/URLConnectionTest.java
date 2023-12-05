package Practice.Network;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

public class URLConnectionTest {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.pusan.ac.kr/kor");
            URLConnection connection = url.openConnection();
            connection.connect();
            // print header fields

            Map<String, List<String>> headers = connection.getHeaderFields();
            for (Map.Entry<String, List<String>> entry: headers.entrySet())
                System.out.println(entry.getKey() + " : " + entry.getValue());
            // print first ten lines of the contents
            try (Scanner in = new Scanner(connection.getInputStream())) {
                for (int n=1; in.hasNextLine() && n <= 10; n++) {
                    System.out.println(in.nextLine());
                }
                if (in.hasNextLine()) System.out.println("...");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
