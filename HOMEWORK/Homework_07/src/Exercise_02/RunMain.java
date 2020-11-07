package Exercise_02;

public class RunMain {
    public static void main(String[] args) {
        IShape[] iShapes = new IShape[3];
        iShapes[0] = new Rectangle(3.4, 5.3);
        iShapes[1] = new Circle(5.5);
        iShapes[2] = new Rectangle(7.4, 4.3);
        System.out.println("---------------------------------------------------");

        for (int i = 0; i < 3; i++) {
            System.out.println("Area of shape[" + i + "]: " + iShapes[i].getArea());
            System.out.println("Perimeter of shape[" + i + "]: " + iShapes[i].getPerimeter());
            System.out.println("---------------------------------------------------");
        }
    }
}
