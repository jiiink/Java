
public class FactorialMain {
	public static void main(String[] args) {
		for ( int i = 1; i <= 10; i ++ ) {
			print(i);
		}
	}
	private static long factorial(final int n) {
		if (n == 0) return 1;
		
		long result = 1;
		for (int i=1; i<=n; i++) {
			result *= i;
		}
		
		return result;
	}
	public static void print(final int i) {
		if (i == 1) {
			System.out.printf("Factorial of %d: 1=%d\n", i, factorial(i));
		} else {
			String str = "1";
			for (int j=2; j<=i; j++) {
				String num = Integer.toString(j);
				str += "*";
				str += num;
			}
			System.out.printf("Factorial of %d: %s=%d\n", i, str, factorial(i));		
		}
	}
}
