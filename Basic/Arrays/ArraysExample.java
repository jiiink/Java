import java.util.Arrays;

public class ArraysExample {
    public static void main(String[] args) {
        int[] array1 = new int[10];
        for (int i=0; i<array1.length; i++) {
            array1[i] = i;
        }
        System.out.println(Arrays.binarySearch(array1, 7)); // 7

        int[] array2 = Arrays.copyOf(array1, 10); // truncating or padding with zeros (if necessary)
        for (int v : array2) System.out.print(v + " "); // 0 1 2 3 4 5 6 7 8 9
        System.out.println(Arrays.equals(array1, array2)); // true

        int[] array3 = Arrays.copyOfRange(array1, 2, 5); // [from ,, to)
        System.out.println();
        for (int v : array3) System.out.print(v + " "); // 2 3 4
        System.out.println(Arrays.equals(array1, array3)); // false

        int[] array4 = new int[5];
        Arrays.fill(array4, 7);
        System.out.println();
        for (int v : array4) System.out.print(v + " "); // 7 7 7 7 7

        System.out.println();
        System.out.println(Arrays.asList("Hello", "Java"));
    }
}