package MID.prob1;

import java.util.ArrayList;
import java.util.List;

public class WordSet {
    private List<String> words = new ArrayList<>();
    private int totalLength = 0;
    private int numberOfWords = 0;

    public WordSet() {}

    public void add(String word) {
        totalLength += word.length();
        if (!isin(word)) {
            words.add(word);
            numberOfWords += 1;
        }
    }

    public String getLongestWord() {
        List<String> result = new ArrayList<>();

        int maxLength = 0;
        for (final String word : words) {
            if (word.length() > maxLength) {
                maxLength = word.length();
            }
        }
        for (final String word : words) {
            if (word.length() == maxLength) {
                result.add(word);
            }
        }
        String msg = "";
        for (final String word : result) {
            msg += word + " ";
        }
        return msg;
    }
    public String getShortestWord() {
        List<String> result = new ArrayList<>();

        int minLength = 10000;
        for (final String word : words) {
            if (word.length() < minLength) {
                minLength = word.length();
            }
        }
        for (final String word : words) {
            if (word.length() == minLength) {
                result.add(word);
            }
        }

        String msg = "";
        for (String word : result) {
            msg += word + " ";
        }
        return msg;
    }
    public boolean isin(String target) {
        for (final String word : words) {
            if (word.equals(target)) {
                return true;
            }
        }
        return false;
    }
    public int getWordCount() {
        return numberOfWords;
    }

    public double getAverageLength() {
        double average = totalLength / numberOfWords;
        return average;
    }
}
