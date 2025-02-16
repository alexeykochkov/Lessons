package Lesson04;

class MyArrayDataException extends Exception {
    public MyArrayDataException(String element) {
        super("Ошибка преобразования элемента '" + element + "' к числу");
    }
}
