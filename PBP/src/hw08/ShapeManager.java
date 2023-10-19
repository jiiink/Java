package hw08;
// import hw08.Shape;
import java.util.*;

public class ShapeManager {
    private List<Shape> shapes = new ArrayList<>();
    public ShapeManager() {}
    public void addShape(Shape s) {
        shapes.add(s);
    }
}
