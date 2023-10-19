package hw08;
import java.lang.Math;

public class Circle extends Shape {
    private int x;
    private int y;
    private int radius;
    
    public Circle(final int x, final int y, final int r) {
        this.x = x;
        this.y = y;
        this.radius = r;
        final float area = (float)Math.PI * r * r;
        setArea(area);
    }
    @Override
    public String toString() {
        String msg = "";
        msg += "Circle " + this.x + " " + this.y + " " + this.getArea() + "\n";
        return msg;
    }
}
