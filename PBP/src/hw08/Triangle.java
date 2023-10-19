package hw08;

public class Triangle extends Shape {
    // private double area;
    public Triangle(int w, int h) {
        super(w, h);
        area = w * h * 0.5;
    }
}
