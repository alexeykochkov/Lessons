package Lesson03.secondTask;

public class Rectangle implements Interface{

    private int sideA;
    private int sideB;
    String backgroundColor;
    String borderColor;

    Rectangle(int sideA, int sideB,  String backgroundColor, String borderColor) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
    }

    @Override
    public int perimeter() {
        return 2*(sideA+sideB);
    }

    @Override
    public int square() {
        return sideA*sideB;
    }

    public void rectangleInfo() {
        System.out.println("Прямоугольник - " + " Площадь: " + square() + ", Периметр: " + perimeter() + ", Цвет фона: " + backgroundColor + ", Цвет границы: " + borderColor);
    }
}
