package hw09;

public class Circle implements MyComparable {
	private final Point center ;
	private final int radius ;
	public Circle(Point c, int r) {
        this.center = c;
        this.radius = r;
    }

    @Override
    public String toString() {
        String msg = "";
        msg += "[" + center.toString() + " " + radius + " " + getSize() + "]";
        return msg; 
    }

    @Override
    public int compareTo(MyComparable other) {
        // TODO Auto-generated method stub
        Circle otherCircle = (Circle)other;
        if (center == otherCircle.center && radius == otherCircle.radius) {
            return 1; // same
        } else {
            return 0; // different
        }
        // throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }
    @Override
    public long getSize() {
        // TODO Auto-generated method stub
        long result;
        result = (long)(Math.PI * Math.pow(radius, 2));
        return result;
        // throw new UnsupportedOperationException("Unimplemented method 'getSize'");
    }
}

