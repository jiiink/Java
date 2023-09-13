package Conversion;
public class Conversion2Wrapper {
    public static void main(String[] args) {
        //Using constructor
        Integer integer1 = new Integer(10);
        System.out.println(integer1);

        //Using static factory method : valueOf()
        //generally better choice
        Integer integer2 = Integer.valueOf(20);
        System.out.println(integer2);

        System.out.println(integer1 + integer2);
    }
}