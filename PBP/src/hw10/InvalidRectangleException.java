package hw10;

public class InvalidRectangleException extends Exception {
	private final int width, height;
	public InvalidRectangleException(int width, int height) {
		this.width = width; this.height = height;
	}
	public int getWidth() { return width; }
	public int getHeight() { return height; }
	@Override
	public String toString() {
		final String msg = "사각형의 넓이와 높이는 양수이어야 합니다. " + getWidth() + " " + getHeight();
		return msg;
	}
}
