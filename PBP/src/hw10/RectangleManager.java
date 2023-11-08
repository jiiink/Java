package hw10;
import java.util.*;

public class RectangleManager {
	private List<Rectangle> rectangles = new ArrayList<>() ;
	private Scanner scannerObject ;

	public RectangleManager(Scanner scannerObject) {
		this.scannerObject = scannerObject;
	}

	public static void main(String[] args) {
		Scanner scannerObject = new Scanner(System.in) ;
		RectangleManager manager = new RectangleManager(scannerObject) ;
		while ( true ) {
			System.out.println("Enter a command: [create width height, zoom id ratio or quit]") ;
			final String command = scannerObject.next() ;
				if ( command.equalsIgnoreCase("create")) { manager.create() ; }
				else if ( command.equalsIgnoreCase("zoom")) { manager.zoom() ; }
				else if ( command.equalsIgnoreCase("showAll")) { manager.showAll() ; }
				else if ( command.equalsIgnoreCase("quit")) { System.out.println("Bye") ; break ; }
		}
		scannerObject.close();
	}

	private void showAll() {
		for (Rectangle rect : rectangles) {
			System.out.println(rect);
		}
	}

	private void zoom() {
		int id = scannerObject.nextInt();
		int ratio = scannerObject.nextInt();
		try {
			System.out.println("Before: " + rectangles.get(id));
			rectangles.get(id).setWidth(rectangles.get(id).getWidth() * ratio);
			rectangles.get(id).setHeight(rectangles.get(id).getHeight() * ratio);
			System.out.println("After: " + rectangles.get(id));
		} catch (IndexOutOfBoundsException e) {
			System.out.println("non exist index. " + e);
		}
		
	}

	private void create() {
		int width = scannerObject.nextInt();
		int height = scannerObject.nextInt();
		try {
			if (!(width > 0 && height > 0)) {
				throw new InvalidRectangleException(width, height);
			}
		} catch (InvalidRectangleException e) {
			System.out.println("width and height must be positive " + width + " " + height);
			return;
		}

		Rectangle rectangle = new Rectangle(width, height);
		rectangles.add(rectangle);
		System.out.println(rectangle + " is added at " + (rectangles.size()-1));
	}
}

