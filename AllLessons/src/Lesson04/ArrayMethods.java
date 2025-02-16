package Lesson04;

public class ArrayMethods {
    public static int sumAllElements(String[][] arr) throws MyArraySizeException, MyArrayDataException {

        if (arr.length != 4) {
            throw new MyArraySizeException();
        }

        for (String[] row : arr) {
            if (row.length != 4) {
                throw new MyArraySizeException();
            }
        }

        int sum = 0;

        for (String[] row : arr) {
            for (String element : row) {
                try {
                    sum += new Integer(element);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(element);
                }
            }
        }

        return sum;
    }
}
