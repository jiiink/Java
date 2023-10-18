package hw08;
// import hw08.Shape;

public class Rectangle extends Shape {
    private int area;
    public Rectangle(int w, int h) {
        super(w, h);
        area = w * h;
    }
}
