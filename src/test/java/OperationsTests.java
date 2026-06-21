import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OperationsTests {


    @DataProvider(name = "factorialData")
    public Object[][] factorialData() {
        return new Object[][]{
                {0, 1},
                {1, 1},
                {5, 120},
                {20, 2432902008176640000L}
        };
    }

    @Test(dataProvider = "factorialData")
    public void shouldCalculateFactorial(int a, long expected) {
        long result = Operations.factorial(a);
        Assert.assertEquals(result, expected);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void negativeCalculateFactorial() {
        Operations.factorial(-1);
    }


    @DataProvider(name = "triangleValidData")
    public Object[][] triangleValidData() {
        return new Object[][]{
                {3, 4, 5, 6},
                {2, 2, 3, 1.984313}
        };
    }

    @Test(dataProvider = "triangleValidData")
    public void shouldCalculateTriangleArea(double a, double b, double c, double expected) {
        double result = Operations.triangleArea(a, b, c);
        Assert.assertEquals(result, expected);
    }

    @DataProvider(name = "triangleInvalidData")
    public Object[][] triangleInvalidData() {
        return new Object[][]{
                {-1, 2, 3},
                {0, 2, 3},
                {1, 2, 3},
                {1, 1, 5}
        };
    }

    @Test(dataProvider = "triangleInvalidData", expectedExceptions = IllegalArgumentException.class)
    public void shouldThrowForInvalidTriangle(double a, double b, double c) {
        Operations.triangleArea(a, b, c);
    }


    @DataProvider(name = "arithmeticData")
    public Object[][] arithmeticData() {
        return new Object[][]{
                {2, 2, '+', 4},
                {2, 2, '*', 4},
                {2, 2, '/', 1},
                {2, 2, '-', 0}
        };
    }

    @Test(dataProvider = "arithmeticData")
    public void shouldCalculateArithmeticOperations(int a, int b, char sign, int expected) {
        double result = Operations.arithmeticOperations(a, b, sign);
        Assert.assertEquals(result, expected);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void shouldThrowForWrongSign() {
        Operations.arithmeticOperations(1, 2, 'a');
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void shouldThrowForDivisionByZero() {
        Operations.arithmeticOperations(10, 0, '/');
    }


    @DataProvider(name = "compareData")
    public Object[][] compareData() {
        return new Object[][]{
                {0, 0, "Числа равны"},
                {-1, -1, "Числа равны"},
                {-1, 1, "Второе число больше"},
                {1, -1, "Первое число больше"}
        };
    }

    @Test(dataProvider = "compareData")
    public void shouldCompare(int a, int b, String expected) {
        String result = Operations.compare(a, b);
        Assert.assertEquals(result, expected);
    }
}
