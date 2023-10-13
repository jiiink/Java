package hw07.edu.pnu.shape;

public class Circle {
	private Point center ;
	private int radius ;
    public Circle(final Point c, final int r) {
        this.center = c;
        this.radius = r;
    }

    @Override
    public String toString() {
        // [ Circle [20, 10] 10 314.000000]

        String msg = "";
        msg += "[ Circle [" + center.getX() + ", " + center.getY() + "] " + radius + " " + 3.14*radius*radius + "]";
        return msg;
    }
}

