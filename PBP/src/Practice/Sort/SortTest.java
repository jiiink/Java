package Practice.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortTest {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        players.add(new Player("Alice", 899));
        players.add(new Player("Bob", 982));
        players.add(new Player("Chloe", 1090));
        players.add(new Player("Dale", 982));
        players.add(new Player("Eric", 1018));
    
        int[] scores = {899, 982, 1090, 982, 1018};
        Arrays.sort(scores);
        System.out.println(Arrays.toString(scores));

        // Method 1. Comparable
        // Collections.sort(players, Collections.reverseOrder());


        // Method 2. Comparator
        // Comparator<Player> comparator = new Comparator<Player>() {
        //     @Override
        //     public int compare(Player a, Player b) {
        //         return b.getScore() - a.getScore();
        //     }
        // };
        // Collections.sort(players, comparator);

        // Method 3. Comparator with Lambda Function
        Collections.sort(players, (a, b) -> a.getScore() - b.getScore());
        System.out.println(players);
    }
}
