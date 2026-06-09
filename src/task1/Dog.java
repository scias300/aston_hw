package task1;

public class Dog extends Animal {
    private static int dogCount = 0;

    Dog(String name) {
        super(name);
        dogCount++;
    }

    public void run(int distance) {
        if (distance >= 0 && distance <= 500) {
            super.run(distance);
        } else {
            System.out.println("Собака может пробежать не более 500м");
        }
    }

    public void swim(int distance) {
        if (distance >= 0 && distance <= 10) {
            super.swim(distance);
        } else {
            System.out.println("Собака может проплыть не более 10м");
        }
    }

    public static int getDogCount() {
        return dogCount;
    }
}
