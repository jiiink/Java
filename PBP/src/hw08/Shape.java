package hw08;
// import java.util.*;
import java.lang.Math;

public abstract class Shape {
    private int width;
    private int height;
    private double area;

    public Shape() {
        width = 0;
        height = 0;
    }
    public Shape(int w, int h) {
        this.width = w;
        this.height = h;
        setArea();
        // this.area = w * h;
    }
    public abstract void setArea();
}
