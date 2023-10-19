package hw08;
// import java.util.*;
// import java.lang.Math;

public abstract class Shape {
    private int width;
    private int height;
    protected double area;

    public Shape() {
        width = 0;
        height = 0;
    }
    public Shape(int w, int h) {
        this.width = w;
        this.height = h;
        // setArea();
        // this.area = w * h;
    }
    @Override
    public String toString() {
        String msg = "";
        msg += width + " " + height;
        return msg;
    }
    // public abstract void setArea();
}
