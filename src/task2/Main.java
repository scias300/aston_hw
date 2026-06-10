package task2;

public class Main {
    public static void main(String[] args) {
        Figure circle = new Circle(5, "Красный", "Черный");

        Figure rectangle = new Rectangle(10, 5, "Синий", "Белый");

        Figure triangle = new Triangle(3, 4, 5, "Зеленый", "Желтый");

        circle.printInfo();
        rectangle.printInfo();
        triangle.printInfo();
    }
}
