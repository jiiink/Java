package hw10;

public class Rectangle {
	private int width, height;
	public Rectangle(int w, int h) {
		this.width = w;
		this.height = h;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public void setWidth(int w) {
		this.width = w;
	}
	public void setHeight(int h) {
		this.height = h;
	}
	@Override
	public String toString() {
		final String msg = "Rectangle: width " + getWidth() + ", height " + getHeight();
		return msg;
	}
}
