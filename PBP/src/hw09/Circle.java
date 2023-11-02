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
        if (getSize() > other.getSize()) { // ascending
            return 1; 
        } else { // descending
            return 0; 
        }
    }
    @Override
    public long getSize() {
        long result = 0;
        result = Math.round(Math.PI * Math.pow(radius, 2));
        return result;
    }
}

