package Test;

import Lesson06.Main;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG {

    @Test
    public void factorialTestNG() {
        Assert.assertEquals(Main.factorial(5), 120);
    }

    @Test
    public void additionTestNG() {
        Assert.assertEquals(Main.addition(1, 2), 3);
    }

    @Test
    public void subtractionTestNG() {
        Assert.assertEquals(Main.subtraction(1, 2), -1);
    }

    @Test
    public void divisionTestNG() {
        Assert.assertEquals(Main.division(4, 2), 2);
    }

    @Test
    public void multiplicationTestNG() {
        Assert.assertEquals(Main.multiplication(2, 2), 4);
    }

    @Test
    public void triangleTestNG() {
        Assert.assertEquals(Main.triangle(2, 2), 2);
    }

    @Test
    public void comparisonTestNG() {
        Assert.assertTrue(Main.comparison(2, 2));
    }

}
