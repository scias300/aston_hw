package task1;

public class Main {
    public static void main(String[] args) {
        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Барсик");
        cats[1] = new Cat("Пельмень");
        cats[2] = new Cat("Сапог");
        Cat.addFood(50);
        for (Cat cat : cats) {
            System.out.println();
            cat.feedCat(20);
        }
    }
}
