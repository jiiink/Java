package hw13;

import java.util.ArrayList;
import java.util.List;

public class RectangleMainStream {
	public static void main(String[] args) {
		List<Rectangle> list0 = new ArrayList<>();
		for ( int i=0; i < 10; i ++ ) {
			Rectangle r = new Rectangle(i+10, i+10);
			list0.add(r);
		}
		
		// A single statement with Stream API
        list0.stream()
            .filter(rect -> rect.getArea() >= 200)
            .filter(rect -> rect.getWidth() % 2 == 0)
            .map(rect -> rect.getName().toUpperCase())
            .forEach(System.out::println);
    }
}
