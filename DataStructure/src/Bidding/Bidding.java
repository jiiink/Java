package Bidding;
import java.util.*;

public class Bidding {
    static Map<Integer, List<String>> bids = new TreeMap<>(Collections.reverseOrder());
    static String winner = "NONE";

    public static void main(String[] args) {
        input();
        process();
        output();
    }

    static void input() {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        while (N-- > 0) {
            final String name = scanner.next();
            final int bid = scanner.nextInt();
            bids.computeIfAbsent(bid, k -> new ArrayList<>()).add(name);
        }

        scanner.close();
    }

    static void process() {
        for (Map.Entry<Integer, List<String>> entry : bids.entrySet()) {
            if (entry.getValue().size() == 1) { // unique bid
                winner = entry.getValue().get(0);
                break;
            }
        }
    }

    static void output() {
        System.out.println(winner);
    }
}
