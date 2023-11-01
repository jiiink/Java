package hw09;

public class Point {
	private final int x, y ;
	public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public String toString() {
        String msg = "";
        msg += "[" + x + ", " + y + "]";
        return msg;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
