package hw09;

import java.util.*;

enum OperationKind {QUIT, INVALID, ADDL, ADDC, SORTA, SORTD, CLEAR, LIST}
enum SortKind {ASCENDING, DESCENDING}

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
                    sortList(comparableList, SortKind.ASCENDING) ;
                    break ;
                case SORTD:
                    sortList(comparableList, SortKind.DESCENDING) ;
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

    private static void sortList(List<MyComparable> list, final SortKind kind) {
        if (kind == SortKind.ASCENDING) {
            for (int i=0; i<list.size()-1; i++) {
                for (int j=i+1; j<list.size(); j++) {
                    if (list.get(i).compareTo(list.get(j)) == 1) {
                        Collections.swap(list, i, j);
                    }
                }
            }
            // Collections.sort(list, Collections.reverseOrder());
        } else {
            for (int i=0; i<list.size()-1; i++) {
                for (int j=i+1; j<list.size(); j++) {
                    if (list.get(i).compareTo(list.get(j)) == 0) {
                        Collections.swap(list, i, j);
                    }
                }
            }
            // Collections.sort(list);
        }
        
    }

    private static Circle createCircle(final Scanner scanner) {
        final Point p = createPoint(scanner);
        final int r = scanner.nextInt();

        final Circle newCircle = new Circle(p, r);
        return newCircle;
    }

    private static Line createLine(final Scanner scanner) {
        final Point p1 = createPoint(scanner);
        final Point p2 = createPoint(scanner);
        
        final Line newLine = new Line(p1, p2);
        return newLine;
    }
    
    private static Point createPoint(final Scanner scanner) {
        final int x = scanner.nextInt();
        final int y = scanner.nextInt();
        final Point p = new Point(x, y);

        return p;
    }

    private static OperationKind getOperation(final Scanner scanner) {
        System.out.print("Enter Operation String! ");
        final String operation = scanner.next().toUpperCase();
        OperationKind op;
        try {
            op = OperationKind.valueOf(operation);
        } catch (IllegalArgumentException e) {
            op = OperationKind.INVALID;
        }
        return op;
    }
    
}
