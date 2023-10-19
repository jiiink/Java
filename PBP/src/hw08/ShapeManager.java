package hw08;
import java.util.*;

public class ShapeManager {
    private List<Shape> shapes = new ArrayList<>();

    public ShapeManager() {}
    public void addShape(final Shape s) {
        shapes.add(s);
    }
    public void printAll() {
        for (Shape shape : shapes) {
            System.out.print(shape);
        }
    }
    public void kindPrint(final String shapeKind) {
        Shape s = null;
        switch (shapeKind) {
            case "R": {
                for (Shape shape : shapes) {
                    if (shape instanceof Rectangle) {
                        s = shape;
                        System.out.print(shape);
                    }
                }
                if (s == null) {
                    System.out.println("NONE");
                }
                break;
            }
            case "T": {
                for (Shape shape : shapes) {
                    if (shape instanceof Triangle) {
                        s = shape;
                        System.out.print(shape);
                    }
                }
                if (s == null) {
                    System.out.println("NONE");
                }
                break;
            }
            case "C": {
                for (Shape shape : shapes) {
                    if (shape instanceof Circle) {
                        s = shape;
                        System.out.print(shape);
                    }
                }
                if (s == null) {
                    System.out.println("NONE");
                }
                break;
            }
            default: {
                System.out.println("Wrong shape type");
                break;
            }
        }
    }
    public void clear() {
        System.out.println(shapes.size());
        shapes.clear();
    }
    public void printTotalArea() {
        double result = 0.0;
        for (Shape shape : shapes) {
            result += shape.getArea();
        }
        System.out.println(result);
    }
}
