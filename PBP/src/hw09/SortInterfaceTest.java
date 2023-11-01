package hw09;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

enum OperationKind {QUIT, INVALID, ADDL, ADDC, SORTA, SORTD, CLEAR, LIST}


public class SortInterfaceTest {
    private static Scanner scanner = new Scanner(System.in);
	private static List<MyComparable> comparableList = new ArrayList<>() ;

	public static void main(String[] args) {
		while ( true ) {
			final OperationKind op = getOperation(scanner) ;
			if ( op == OperationKind.QUIT ) {
				System.out.println("Bye") ;
				break;
			}
			if ( op == OperationKind.INVALID ) {
				System.out.println("Invalid Operation!") ;
				continue ;
			}
            switch ( op ) {
                case ADDL : {
                    final Line newLine = createLine(scanner) ;
                    comparableList.add(newLine);
                    System.out.println(newLine) ;
                    break ;
                }
                case ADDC : {
                    final Circle newCircle = createCircle(scanner) ;
                    comparableList.add(newCircle);
                    System.out.println(newCircle) ;
                    break ;
                }
                case SORTA:
                    // sortList(comparableList, SortKind.ASCENDING) ;
                    break ;
                case SORTD:
                    // sortList(comparableList, SortKind.DESCENDING) ;
                    break ;
                case CLEAR:
                    comparableList.clear() ;
                    break ;
                case LIST: 
                    System.out.println(comparableList) ;
                    break ;
                default: break;
                }
            }
        }

    private static Circle createCircle(Scanner scanner) {
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int r = scanner.nextInt();
        Point p = new Point(x, y);

        Circle newCircle = new Circle(p, r);
        return newCircle;
    }

    private static Line createLine(Scanner scanner) {
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        Point p1 = new Point(x, y);
        x = scanner.nextInt();
        y = scanner.nextInt();
        Point p2 = new Point(x, y);
        
        final Line newLine = new Line(p1, p2);
        return newLine;
    }

    private static OperationKind getOperation(Scanner scanner) {
        System.out.print("Enter Operation String! ");
        String operation = scanner.next().toUpperCase();
        OperationKind op;
        try {
            op = OperationKind.valueOf(operation);
        } catch (IllegalArgumentException e) {
            op = OperationKind.INVALID;
        }
        return op;
    }
    
}
