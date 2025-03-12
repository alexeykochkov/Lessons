package Lesson04;

public class Main {
    public static void main(String[] args) {

        String[][] array = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};
        String[][] array1 = {{"1", "2", "3", "ddd"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};
        String[][] array2 = {{"1", "2", "3", "ddd"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}};

        try {
            System.out.println("Сумма элементов массива: " + ArrayMethods.sumAllElements(array));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println(e.getMessage());
        }

        try {
            System.out.println("Сумма элементов массива: " + ArrayMethods.sumAllElements(array1));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println(e.getMessage());
        }

        try {
            System.out.println("Сумма элементов массива: " + ArrayMethods.sumAllElements(array2));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println(e.getMessage());
        }
    }
}
