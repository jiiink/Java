package prob1;
import java.util.*;
public class WordLength {
    public static void main(String[] args) {
        WordSet wordSet = new WordSet();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            final String word = scanner.next();
            if (word.equalsIgnoreCase("QUIT")) break;
            wordSet.add(word);
        }
        scanner.close();

        System.out.println(wordSet.getLongestWord());
        System.out.println(wordSet.getShortestWord());
        System.out.println(wordSet.getWordCount());
        System.out.println(wordSet.getAverageLength());
    }
}
