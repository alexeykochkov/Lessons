package Lesson03.secondTask;

public class Triangle implements Interface {

    private String backgroundColor;
    private String borderColor;
    private int sideA;
    private int sideB;
    private int sideC;
    private int height;

    Triangle(int sideA, int sideB, int sideC, String backgroundColor, String borderColor, int height) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.height = height;
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
    }

    @Override
    public int perimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public int square() {
        return (sideA * height) / 2;
    }

    public void triangleInfo() {
        System.out.println("Треугольник - " + " Площадь: " + square() + ", Периметр: " + perimeter() + ", Цвет фона: " + backgroundColor + ", Цвет границы: " + borderColor);
    }
}
