package hw08;

public abstract class Shape {
    private int width;
    private int height;
    private float area;

    public Shape() {
        this.width = 0;
        this.height = 0;
    }
    public Shape(final int w, final int h) {
        this.width = w;
        this.height = h;
    }
    @Override
    public String toString() {
        String msg = "";
        msg += width + " " + height + " " + area + "\n";
        return msg;
    }
    public void setArea(float area) {
        this.area = area;
    }
    public float getArea() {
        return this.area;
    }
}
