package hw09;


public class Line implements MyComparable {
	private final Point point1, point2 ;
	public Line(Point p1, Point p2) {
        this.point1 = p1;
        this.point2 = p2;
    }
    @Override
    public long getSize() {
        long result = 0;
        result = (long)Math.sqrt(Math.pow((point1.getX() - point2.getX()), 2) + Math.pow((point1.getY() - point2.getY()), 2));
        return result;
    }
    @Override
    public int compareTo(final MyComparable other) {
        Line otherLine = (Line)other;
        if (point1 == otherLine.point1 && point2 == otherLine.point2) {
            return 1; // same
        } else {
            return 0; // different
        }
    }

    @Override
    public String toString() {
        String msg = "";
        msg += "[" + point1.toString() + " " + point2.toString() + " " + getSize() + "]";
        return msg;
    }
}
