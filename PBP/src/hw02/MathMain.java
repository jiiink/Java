package hw02;

public class MathMain {
	public static void main(String[] args) {
		int begin = 2;
		int end = 10;
		
		long sum = getSumBetween(begin, end);
		System.out.printf("Sum between %d and %d : %,d%n", begin, end, sum);
		printSumBetween(begin, end, sum);

		long product = getProductBetween(begin, end);
		System.out.printf("Product between %d and %d : %,d%n", begin, end, product);
		printProductBetween(begin, end, product);
	}
	private static long getSumBetween(final int begin, final int end) {
		long sum = 0L;
		
		for (int i=begin; i<=end; i++) {
			sum += i;
		}
		
		return sum;
	}
	private static void printSumBetween(final int begin, final int end, final long sum) {
		String line = String.valueOf(begin);
		for (int i=begin+1; i<=end; i++) {
			line += "+";
			line += String.valueOf(i);
		}
		line += " = ";
		System.out.printf("%s%,d%n", line, sum);
	}
	private static long getProductBetween(final int begin, final int end) {
		long result = 1;
		for (int i=begin; i<=end; i++) {
			result *= i;
		}
		return result;
	}
	private static void printProductBetween(final int begin, final int end, final long product) {
		String line = String.valueOf(begin);
		for (int i=begin+1; i<=end; i++) {
			line += "*";
			line += String.valueOf(i);
		}
		line += " = ";
		System.out.printf("%s%,d%n", line, product);
	}
}
