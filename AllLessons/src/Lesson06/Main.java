package Lesson06;

public class Main {

    public static int addition(int a, int b) {
        return (a + b);
    }

    public static int subtraction(int a, int b) {
        return (a - b);
    }

    public static int division(int a, int b) {
        return (a / b);
    }

    public static int multiplication(int a, int b) {
        return (a * b);
    }

    public static int factorial(int input) {
        int result = 1;
        for (int i = 1; i <= input; i++) {
            result = result * i;
        }
        return result;
    }

    public static int triangle(int base, int height) {
        return (base * height) / 2;
    }

    public static boolean comparison(int a, int b) {
        return a == b;
    }

    public static void main(String[] args) {

    }
}
