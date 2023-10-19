package hw08;
// import java.util.*;
import java.lang.Math;

public class Circle extends Shape {
    private int x;
    private int y;
    private int radius;
    // private double area;
    
    public Circle(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.radius = r;
        area = Math.PI * r * r;
    }
}
