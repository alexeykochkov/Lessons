package Test;

import Lesson06.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JunitTest {

    @DisplayName("Факториал")
    @Test
    public void factorialTest() {
        Assertions.assertEquals(Main.factorial(5), 120);
    }

    @DisplayName("Сложение целых чисел")
    @Test
    public void additionTest() {
        Assertions.assertEquals(Main.addition(1, 2), 3);
    }

    @DisplayName("Вычитание целых чисел")
    @Test
    public void subtractionTest() {
        Assertions.assertEquals(Main.subtraction(1, 2), -1);
    }

    @DisplayName("Деление целых чисел")
    @Test
    public void divisionTest() {
        Assertions.assertEquals(Main.division(4, 2), 2);
    }

    @DisplayName("Умножение целых чисел")
    @Test
    public void multiplicationTest() {
        Assertions.assertEquals(Main.multiplication(2, 2), 4);
    }

    @DisplayName("Площадь треугольника")
    @Test
    public void triangleTest() {
        Assertions.assertEquals(Main.triangle(2, 2), 2);
    }

    @DisplayName("Сравнение целых чисел")
    @Test
    public void comparisonTest() {
        Assertions.assertTrue(Main.comparison(2, 2));
    }

}


