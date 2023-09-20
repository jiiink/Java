package hw03;
import java.util.Scanner;

enum Command {
	// Your code here
//	String command = "";
	ADD("ADD"), LIST("LIST"), SUM("SUM"), QUIT("QUIT"), INVALID("INVALID");
	private final String cmd;
	private Command(final String command) {
		if (command != "ADD" && command != "LIST" && command != "SUM" && command != "QUIT") {
			System.out.println("It is not in enum");
			this.cmd = "INVALID";
		} else {
			this.cmd = command;
		}
	}
}
public class ArrayEnum {
	public static void main(String[] args) {
		// Your code here
		int[] values = new int[100];
		int index = 0;
		final Scanner scanner = new Scanner(System.in);
//		String str = scanner.nextLine();
//		System.out.println(str);
		while ( true ) {
			final Command command = getCommand(scanner); // Command is enum
			if ( command == Command.QUIT ) {
				System.out.println("Bye!");
				break;
			}
			switch ( command ) {
			case ADD:
				final int newValue = getValue(scanner);
				values[index] = newValue;
				index++;
				break;
			case LIST:
				printList(values, index);
				break;
			case SUM:
				System.out.println(getSum(values, index));
				break;
			case INVALID:
				System.out.println("Invalid Command");
				default: break;
			}
		}
		scanner.close();
	}
	private static Command getCommand(Scanner scanner) {
		String str = scanner.next();
		Command command = Command.valueOf(str.toUpperCase());
		return command;
	}
	private static int getValue(Scanner scanner) {
		int value = scanner.nextInt();
		
		return value;
	}
	private static void printList(int[] values, int index) {
		for (int i=0; i<index; i++) {
			System.out.printf("%d ", values[i]);
		}
		System.out.println();
	}
	private static int getSum(int[] values, int index) {
		int sum = 0;
		for (int i=0; i<=index; i++) {
			sum += values[i];
		}
		return sum;
	}
	// Your code here
//	private static Command Command(String upperCase) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}