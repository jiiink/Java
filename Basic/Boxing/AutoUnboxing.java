import java.util.ArrayList;
import java.util.List;

public class AutoUnboxing {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        for (int i=1; i<=5; i++) {
            integerList.add(i); //auto boxing
        }
        System.out.println(integerList);

        int sumOfEven = 0;
        for (Integer i : integerList) {
            if (i % 2 == 0) {       // Integer to int for % 
                sumOfEven += i;     // Integer to int
            }
        }
        System.out.println(sumOfEven);
    }
}