package hw07.edu.pnu.shape;

public class Circle {
	private Point center ;
	private int radius ;
    private double area;
    public Circle(final Point c, final int r) {
        this.center = c;
        this.radius = r;
        this.area = 3.14 * r*r;
    }

    @Override
    public String toString() {
        // [ Circle [20, 10] 10 314.000000]

        String msg = "";
        msg += "[ Circle " + center.toString() + radius + " " + area + "]";
        // center.toString()
        return msg;
    }
}

