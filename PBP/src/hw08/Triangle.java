package hw08;

public class Triangle extends Shape {
    public Triangle(final int w, final int h) {
        super(w, h);
        final float area = w * h / 2;
        setArea(area);
    }
    @Override
    public String toString() {
        String msg = "";
        msg += "Triangle " + super.toString();
        return msg;
    }
}
