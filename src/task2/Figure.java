package task2;

public interface Figure {
    double getArea();

    double[] getSides();

    String getFillColor();

    String getBorderColor();

    default double getPerimeter() {
        double perimeter = 0;

        for (double side : getSides()) {
            perimeter += side;
        }

        return perimeter;
    }

    default void printInfo() {
        System.out.println(
                "Периметр: " + getPerimeter() +
                        ", Площадь: " + getArea() +
                        ", Цвет фона: " + getFillColor() +
                        ", Цвет границ: " + getBorderColor()
        );
    }
}
