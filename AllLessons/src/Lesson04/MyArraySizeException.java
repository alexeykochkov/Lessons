package Lesson04;

class MyArraySizeException extends Exception {
    public MyArraySizeException() {
        super("Размер массива должен быть 4x4");
    }
}
