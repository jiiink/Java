package hw03;
import java.util.Scanner;

enum Command {
	// Your code here
    ADD("ADD"), LIST("LIST"), SUM("SUM"), QUIT("QUIT"), INVALID("INVALID");
    private final String command;
    Command(final String command) {
        this.command = command;
    }
};
public class ArrayEnum {
	public static void main(String[] args) {
		// Your code here
        final int[] values = new int[100];
        int index = 0;

		final Scanner scanner = new Scanner(System.in);
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
	// Your code here
    private static final Command getCommand(final Scanner scanner) {
        String cmd = scanner.next().toString().toUpperCase();
        if (!cmd.equals("ADD") && !cmd.equals("LIST") && !cmd.equals("SUM") && !cmd.equals("QUIT")) {
            cmd = "INVALID";
        }
        final Command command = Command.valueOf(cmd);
        
        return command;
    }
    private static final int getValue(final Scanner scanner) {
        final int value = scanner.nextInt();
        return value;
    }
    private static void printList(final int[] values, final int index) {
        for (int i=0; i<index; i++) {
            System.out.printf("%d ", values[i]);
        }
        System.out.println();
    }
    private static final int getSum(final int[] values, final int index) {
        int sum = 0;
        for (int i=0; i<index; i++) {
            sum += values[i];
        }
        return sum;
    }
}
