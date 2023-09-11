public class FormatTest {
    public static void main(String[] args) {
        long n = 123456;

        System.out.printf("%d%n", n);
        System.out.printf("%10d%n", n); // width
        System.out.printf("%-10d%n", n); // left-justified
        System.out.printf("%010d%n", n); // leading zeroes
        System.out.printf("%+10d%n", n); // sign character
        System.out.printf("%,10d%n", n); // group character
        System.out.printf("%d\t%1$#x%n%n", n); // argument index and hexadecimal

        double pi = Math.PI;
        System.out.printf("%n%f%n", pi); // fixed-point format
        System.out.printf("%e%n", pi); // exponential format
        System.out.printf("%10.3f%n", pi); // width/precision in fixed-point format
        System.out.printf("%10.3e%n", pi); // width/precision in exponential format
        System.out.printf("%+-10.3f%n", pi); // sign character and left-justified
    }
}