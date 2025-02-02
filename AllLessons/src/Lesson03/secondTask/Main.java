package Lesson03.secondTask;

public class Main {
    public static void main(String[] args) {
        Triangle t = new Triangle(8, 2, 3, "Black", "Blue", 3);
        Rectangle r = new Rectangle(7, 2, "Green", "Yelloy");
        Circle c = new Circle("Orange", "Grey", 5);

        t.triangleInfo();
        r.rectangleInfo();
        c.circleInfo();

    }
}
