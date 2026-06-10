package task1;

public class Cat extends Animal {
    private static int catCount = 0;
    private boolean isFull;
    private static int amountOfFood = 0;

    Cat(String name) {
        super(name);
        this.isFull = false;
        catCount++;
    }

    public void run(int distance) {
        if (distance >= 0 && distance <= 200) {
            super.run(distance);
        } else {
            System.out.println("Кот может пробежать не более 200м");
        }
    }

    public void swim(int distance) {
        System.out.println("Коты не умеют плавать");
    }

    public static int getCatCount() {
        return catCount;
    }

    public static int getAmountOfFood() {
        return amountOfFood;
    }

    public void feedCat(int amount) {
        if (amountOfFood - amount < 0) {
            System.out.println(this.name + " голоден");
            System.out.println("В мискве недостаточно еды для кота по имени " + this.name + ", в данный момент в ней: " + amountOfFood);
        } else {
            System.out.println(this.name + " сыт");
            this.isFull = true;
            amountOfFood -= amount;
            System.out.println("Сейчас в миске " + amountOfFood + " еды");
        }
    }

    public static void addFood(int amount) {
        amountOfFood += amount;
        System.out.println("Добавлено " + amount + " еды");
        System.out.println("Сейчас в миске " + amountOfFood + " еды");
    }

    public boolean getIsFull() {
        return this.isFull;
    }
}
