package Lesson03.secondTask;

public class Circle implements Interface {

    private String backgroundColor;
    private String borderColor;
    private int radius;

    Circle(String backgroundColor, String borderColor, int radius) {
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
        this.radius = radius;
    }

    @Override
    public int perimeter() {
        double pi = Math.PI;
        int piInt = (int) Math.floor(pi);
        return 2*piInt*radius;
    }

    @Override
    public int square() {
        double pi = Math.PI;
        int piInt = (int) Math.floor(pi);
        return piInt*(radius*radius);
    }

    public void circleInfo() {
        System.out.println("Круг - " + " Площадь: " + square() + ", Периметр: " + perimeter() + ", Цвет фона: " + backgroundColor + ", Цвет границы: " + borderColor);
    }
}
