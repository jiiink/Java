package hw07.edu.pnu.shape;

public class Rectangle {
	private int width, height ;
    private double area;
    public Rectangle(final int w, final int h) {
        this.width = w;
        this.height = h;
        this.area = w * h;
    }

    @Override
    public String toString() {
        final String msg = "[ Rectangle " + width + " " + height + " " + String.format("%.6f", area) + "]";
        return msg; 
    }
}

