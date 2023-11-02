package Basic.Boxing;

import java.util.ArrayList;
import java.util.List;

public class AutoBoxing {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        for (int i=1; i<10; i++) {
            integerList.add(i); //int to Integer //add(Integer.valueOf(i))
        }
        System.out.println(integerList);
    }
}