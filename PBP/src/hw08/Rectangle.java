package hw08;

public class Rectangle extends Shape {
    public Rectangle(final int w, final int h) {
        super(w, h);
        this.setArea(w * h);
    }
    @Override
    public String toString() {
        String msg = "";
        msg += "Rectangle " + super.toString();
        return msg;
    }
}
