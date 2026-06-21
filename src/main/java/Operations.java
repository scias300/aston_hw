public class Operations {
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Некорректное число");
        }

        long result = 1;

        for (int i = 2; i <= n; i++) {
            result *= i;
        }

        return result;
    }

    public static double triangleArea(double a, double b, double c) {
        if (a > 0 && b > 0 && c > 0 && a + b > c && a + c > b && b + c > a) {
            double p = (a + b + c) / 2;
            return Math.round(Math.sqrt(p * (p - a) * (p - b) * (p - c)) * 1_000_000.0) / 1_000_000.0;
        } else {
            throw new IllegalArgumentException("Некорректное число");
        }
    }

    public static int arithmeticOperations(int a, int b, char sign) {
        switch (sign) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            default:
                throw new IllegalArgumentException("Некорректный арифметический знак");
        }
    }

    public static String compare(int a, int b) {
        if (a == b) {
            return "Числа равны";
        } else if (a > b) {
            return "Первое число больше";
        } else {
            return "Второе число больше";
        }
    }
}
