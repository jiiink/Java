package Practice.Assertion;

public class PrePostCondition {
    public static void sort(int[] a) {
        assert a != null;
        System.out.println("No error");
        // for (int i=0; i<a.length-1; i++) {
        //     for (int j=i+1; j<a.length-1; j++) {
        //         if (a[i] < a[j]) {
        //             int t = a[i];
        //             a[i] = a[j];
        //             a[j] = t;
        //         }
        //     }
        // }
        // for (int i=0; i<a.length - 1; i++) {
        //     assert a[i] >= a[i+1];
        // }
    }
    public static void main(String[] args) {
        int[] a = {10, 20, 30};
        int[] b = null;
        sort(null);
    }
}
