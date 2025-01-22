import java.util.Arrays;

public class Program {
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
        boolean bool = true;
        if (c >= 10 && c <= 20) {
            return bool;
        } else {
            return !bool;
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
        boolean bool = true;
        if (a < 0) {
            return bool;
        } else {
            return !bool;
        }
    }

    /**
     * Задача №8
     */

    public static void stringNumber ( String a, int b) {
        for (int i = 0; i < b; i++) {
            System.out.println(a);
        }
    }

    /**
     * Задача №9
     */
    public static boolean leapOrNot (int year) {
        boolean leapBool = true;
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            return leapBool;
        } else {
            return  !leapBool;
        }
    }

    /**
     * Задача №10
     */
    public static void replaseNumber () {
        int[] array = {1,1,1,0,0,0};
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else if (array[i] == 1) {
                array[i] = 0;
            }

        }
        System.out.print(Arrays.toString(array));
    }

    /**
     * Задача №11
     */

//    public static void emptyArray () {
//        int[] array = new int[100];
//
//    }
    public static void main(String[] args) {

        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();

        boolean resultInt = tooSumInt(2, 2);
        System.out.print(resultInt);

        whatIsInt(2);

        boolean resultBool = whatIsBool(1);
        System.out.print(resultBool);

        stringNumber("Строка", 3);

        boolean resulLeapYear = leapOrNot(2024);
        System.out.print(resulLeapYear);

        replaseNumber();
    }
}
