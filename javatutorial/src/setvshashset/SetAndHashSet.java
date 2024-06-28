package setvshashset;

import java.util.HashSet;
import java.util.Set;

public class SetAndHashSet {
    public static void main(String[] args) {

        Set<String> names = new HashSet<>();
        names.add("Walter");
        names.add("Walter");
        names.add("Jessie");
        names.add("Skyler");
        names.add("Mike");
        names.add("Saul");

        names.remove("Walter");

        System.out.println(names);

    }
}
