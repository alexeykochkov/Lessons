package Lesson01;

import java.util.Arrays;

public class Lesson01 {
    /**
     * Задача №1
     */
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    /**
     * Задача №2
     */
    public static void checkSumSign() {
        int a = 1;
        int b = -10;
        int c = a + b;
        if (c >= 0) {
            System.out.println("positive number");
        } else {
            System.out.println("negative number");
        }
    }

    /**
     * Задача №3
     */
    public static void printColor() {
        int value = -5;
        if (value <= 0) {
            System.out.println("Red");
        } else if (value > 0 && value <= 100) {
            System.out.println("Yellow");
        } else if (value > 100) {
            System.out.println("Green");
        }
    }

    /**
     * Задача №4
     */
    public static void compareNumbers() {
        int a = 1;
        int b = 2;
        if (a >= b) {
            System.out.println("a>=b");
        } else {
            System.out.println("a<b");
        }
    }

    /**
     * Задача №5
     */
    public static boolean tooSumInt(int a, int b) {
        int c = a + b;
         if (c >= 10 && c <= 20) {
             System.out.println(true);
            return true;
        } else {
             System.out.println(false);
             return false;
        }
    }

    /**
     * Задача №6
     */
    public static void whatIsInt(int a) {
        if (a >= 0) {
            System.out.println("positive number");
        } else {
            System.out.println("negative number");
        }
    }

    /**
     * Задача №7
     */
    public static boolean whatIsBool(int a) {
        if (a < 0) {
            System.out.println(true);
            return true;
        } else {
            System.out.println(false);
            return false;
        }
    }

    /**
     * Задача №8
     */

    public static void stringNumber(String a, int b) {
        for (int i = 0; i < b; i++) {
            System.out.println(a);
        }
    }

    /**
     * Задача №9
     */
    public static boolean leapOrNot(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            System.out.println(true);
            return true;
        } else {
            System.out.println(false);
            return false;
        }
    }

    /**
     * Задача №10
     */
    public static void replaseNumber() {
        int[] array = {1, 1, 1, 0, 0, 0};
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else if (array[i] == 1) {
                array[i] = 0;
            }

        }
        System.out.println(Arrays.toString(array));
    }

    /**
     * Задача №11
     */
    public static void emptyArray() {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = 1;
            array[i] = i + 1;
        }
        System.out.println(Arrays.toString(array));
    }

    /**
     * Задача №12
     */
    public static void multOverTwo() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] = array[i] * 2;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    /**
     * Задача №13
     */
    public static void zeroDiag() {
        int massiv[][] = new int[8][8];
        for (int i = 0; i < massiv.length; i++) {
            for (int j = 0; j < massiv.length; j++) {
                if (i == j) {
                    massiv[i][j] = 1;
                }
                System.out.print(massiv[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Задача №14
     */
    public static void newArray(int len, int initialValue) {
        int[] mass = new int[len];
        for (int i = 0; i < mass.length; i++) {
            mass[i] = initialValue;
        }
        System.out.println(Arrays.toString(mass));
    }

    public static void main(String[] args) {

        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        tooSumInt(1,2);
        whatIsInt(2);
        whatIsBool(1);
        stringNumber("Строка", 3);
        leapOrNot(2024);
        replaseNumber();
        emptyArray();
        multOverTwo();
        zeroDiag();
        newArray(10, 3);

    }
}
