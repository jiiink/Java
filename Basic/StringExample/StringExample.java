import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringExample {
    public static void main(String[] args) {
        String greeting = "Hello";

        // length, charAt
        for (int i=0; i<greeting.length(); i++) {
            System.out.println(greeting.charAt(i));
        }

        // substring (int beginIndex, int endIndex) : [beginIndex .. endIndex-1]
        String hel = greeting.substring(0, 3);
        System.out.println(hel); // Hel

        // concatenation
        String language = "Java !";
        String msg = greeting + "" + language;
        System.out.println("Welcom to " + msg); // Welcome to Hello Java !

        // equality, use equals; DO NOT USE ==
        if (greeting.equals("hello"))
            System.out.println("Exactly same!");
        if (greeting.equalsIgnoreCase("hello"))
            System.out.println("Same when case ignored");  // this executed
        
        // comparison
        if (greeting.compareTo(language) < 0)
            System.out.println(greeting + " comes before " + language); // this executed
        else if (greeting.compareTo(language) > 0)
            System.out.println(greeting + " comes after " + language);
        else 
            System.out.println(greeting + " equals with " + language);

        // replacement
        String greeting2 = greeting.replace('l', 'L');
        System.out.println("The original string : " + greeting + " After replacement : " + greeting2);

        // indexOf, lastIndexOf
        System.out.println(greeting.indexOf('l'));     // 2
        System.out.println(greeting.lastIndexOf('l')); // 3
        System.out.println(greeting.indexOf('L'));     // -1
        System.out.println(greeting.indexOf("lo"));   // 3

        // startsWith, endsWith
        System.out.println(greeting.startsWith("He"));  // true
        System.out.println(greeting.startsWith("he"));  // false
        System.out.println(greeting.endsWith("lo"));    // true
        System.out.println(greeting.startsWith("hlo")); // false

        // split(String regex)
        String line = "first : second : third";
        String[] items1 = line.split(":");
        System.out.println(Arrays.asList(items1)); // [first, second, third]
        String[] items2 = line.split("\\s*:\\s*"); 
        System.out.println(Arrays.asList(items2)); // [first, second, third]

        //toLowerCase, toUpperCase, trim
        System.out.println(String.join("-", "I", "Love", "Java")); // I-Love-Java
    }
}