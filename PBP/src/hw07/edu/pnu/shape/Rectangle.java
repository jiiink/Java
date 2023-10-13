package hw07.edu.pnu.shape;

public class Rectangle {
	private int width, height ;
    public Rectangle(final int w, final int h) {
        this.width = w;
        this.height = h;
    }

    @Override
    public String toString() {
        // [ Rectangle 10 10 100.000000]
        String msg = "";
        msg = "[ Rectangle " + width + " " + height + " " + width*height + "]";
        return msg; 
    }
}

