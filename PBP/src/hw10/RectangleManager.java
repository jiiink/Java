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
		for (final Rectangle rectangle : rectangles) {
			System.out.println(rectangle);
		}
	}

	private void zoom() {
		try {
			final int id = scannerObject.nextInt();
			final int ratio = scannerObject.nextInt();
			System.out.println("Before: " + rectangles.get(id));
			rectangles.get(id).setWidth(rectangles.get(id).getWidth() * ratio);
			rectangles.get(id).setHeight(rectangles.get(id).getHeight() * ratio);
			System.out.println("After: " + rectangles.get(id));
		} catch (IndexOutOfBoundsException e) {
			System.out.println("존재하지 않는 배열의 원소를 접근했습니다." + e);
		}
	}

	private void create() {
		try {
			final int width = scannerObject.nextInt();
			final int height = scannerObject.nextInt();
			if (width < 0 || height < 0) {
				throw new InvalidRectangleException(width, height);
			}
			final Rectangle rectangle = new Rectangle(width, height);
			rectangles.add(rectangle);
			System.out.println(rectangle + " is added at " + (rectangles.size()-1));
			
		} catch (InvalidRectangleException e) {
			System.out.println(e);
		} catch (InputMismatchException e) {
			System.out.println("입력된 인자의 형식이 맞지 않습니다.");
		}
	}
}

