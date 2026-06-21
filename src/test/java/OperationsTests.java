import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;


public class OperationsTests {
    @ParameterizedTest
    @CsvSource({
            "0, 1",
            "1, 1",
            "5, 120",
            "20, 2432902008176640000"
    })
    void shouldCalculateFactorial(int a, long expected) {
        long result = Operations.factorial(a);
        assertEquals(expected, result);
    }

    @Test
    void negativeCalculateFactorial() {
        assertThrows(IllegalArgumentException.class, () -> Operations.factorial(-1));
    }

    @ParameterizedTest
    @CsvSource({
            "3, 4, 5, 6",
            "2, 2, 3, 1.984313"
    })
    void shouldCalculateTriangleArea(double a, double b, double c, double expected) {

        assertEquals(expected, Operations.triangleArea(a, b, c));
    }

    @ParameterizedTest
    @CsvSource({
            "-1, 2, 3",
            "0, 2, 3",
            "1, 2, 3",
            "1, 1, 5"
    })
    void shouldThrowForInvalidTriangle(double a, double b, double c) {

        assertThrows(IllegalArgumentException.class, () -> Operations.triangleArea(a, b, c));
    }

    @ParameterizedTest
    @CsvSource({
            "2, 2, +, 4",
            "2, 2, *, 4",
            "2, 2, /, 1",
            "2, 2, -, 0"

    })
    void shouldCalculateArithmeticOperations(int a, int b, char sign, int expected) {
        double result = Operations.arithmeticOperations(a, b, sign);
        assertEquals(expected, result);
    }

    @Test
    void shouldThrowForWrongSign() {
        assertThrows(IllegalArgumentException.class, () -> Operations.arithmeticOperations(1, 2, 'a'));
    }

    @Test
    void shouldThrowForDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> Operations.arithmeticOperations(10, 0, '/'));
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0, Числа равны",
            "-1, -1, Числа равны",
            "-1, 1, Второе число больше",
            "1, -1, Первое число больше"

    })
    void shouldCompare(int a, int b, String expected) {
        String result = Operations.compare(a, b);
        assertEquals(expected, result);
    }
}
