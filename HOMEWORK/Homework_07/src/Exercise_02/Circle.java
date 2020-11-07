package Exercise_02;

public class Circle implements IShape {
    private double radius;
    double PI = 3.14;

    public Circle() {

    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return PI * Math.pow(this.radius, 2);
    }

    @Override
    public double getPerimeter() {
        return 2 * PI * this.radius;
    }
}
