package hw08;
import java.util.Scanner;
// import hw08.Shape;
// import org.w3c.dom.css.Rect;

// import hw07.edu.pnu.edit.Editor;
// import hw07.edu.pnu.shape.Point;

enum OperationKind {ADD, PRINTALL, PRINT, REMOVEALL, TOTALAREA, QUIT, INVALID}

public class ShapeManagerTest {
    private static ShapeManager shapeManager = new ShapeManager() ;
	// private static char[] newShape;
	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		while ( true ) {
			final OperationKind op = getOperation(scanner) ;
			if ( op == OperationKind.QUIT ) {
				System.out.println("Bye") ; break;
			}
			if ( op == OperationKind.INVALID ) {
				System.out.println("Invalid Operation!") ; continue ;
			}
			switch ( op ) {
			
            case ADD : {
				Shape newShape = null;
				String shapeType = scanner.next().toUpperCase();
				int width = scanner.nextInt();
				int height = scanner.nextInt();
                if (shapeType.equals("R")) {
                    newShape = new Rectangle(width, height);
                } else if (shapeType.equals("T")) {
                    newShape = new Triangle(width, height);
				} else if (shapeType.equals("C")) {
					int r = scanner.nextInt();
					newShape = new Circle(width, height, r);
				}
				System.out.println(newShape);
				shapeManager.addShape(newShape);
				break;
            }
			
			case TOTALAREA: {
				shapeManager.printTotalArea(); 
				// System.out.println(result);
				break;
			}
			case REMOVEALL: shapeManager.clear() ; break ;
			case PRINTALL:  shapeManager.printAll() ; break ;
			case PRINT: {
				String shapeType = scanner.next().toUpperCase();
				// if (shapeType.equals("R")) {
				shapeManager.kindPrint(shapeType);
				// }
				break;
			}
			
			default: break;
			}
		}
		scanner.close();
	}
	// private static Shape createShape(Scanner scanner) {
	// 	String kind = scanner.next();
	// 	int width = scanner.nextInt();
	// 	int height = scanner.nextInt();
	// 	Shape newShape = null;
	// 	switch (kind) {
	// 		case "R": {
	// 			newShape = new Rectangle(width, height);
	// 			break;
	// 		}
	// 		case "T": {
	// 			newShape = new Triangle(width, height);
	// 			break;
	// 		}
	// 		case "C": {
	// 			int radius = scanner.nextInt();
	// 			newShape = new Circle(width, height, radius);
	// 			break;
	// 		}
	// 		// default: break;
	// 	}
	// 	return newShape;
	// }
	// private static Circle createCircle(final Scanner scanner) {
	// 	final int x = scanner.nextInt() ;
	// 	final int y = scanner.nextInt() ;		
	// 	final int radius = scanner.nextInt() ;
		
	// 	final Circle newCircle = new Circle(new Point(x, y), radius) ;
	// 	return newCircle ;
	// }
	
	// private static Rectangle createRectangle(final Scanner scanner) {
	// 	final int width = scanner.nextInt() ;
	// 	final int height = scanner.nextInt() ;		
		
	// 	final Rectangle newRectangle = new Rectangle(width, height) ;
	// 	return newRectangle ;
	// }
	private static OperationKind getOperation(final Scanner scanner) {
		System.out.print("Enter Operation String! ") ;
		final String operation = scanner.next() ;
		
		OperationKind kind;
		try {
			kind = OperationKind.valueOf(operation.toUpperCase());
		}
		catch ( IllegalArgumentException e ) {
			kind = OperationKind.INVALID;
		}
		return kind;
	}
}
