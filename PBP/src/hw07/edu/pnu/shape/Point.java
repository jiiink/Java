package hw07.edu.pnu.shape;

public class Point {
	private int x, y ;
    public Point(final int x, final int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }

    @Override
    public String toString() {
        String msg = "[" + x + ", " + y + "] ";
        return msg;
    }
}

