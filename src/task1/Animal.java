package task1;

public class Animal {
    protected String name;
    private static int animalCount = 0;

    Animal(String name) {
        this.name = name;
        animalCount++;
    }

    public void run(int distance) {
        System.out.println(this.name + " пробежал " + distance + " м.");
    }

    public void swim(int distance) {
        System.out.println(this.name + " проплыл " + distance + " м.");
    }

    public static int getAnimalCount() {
        return animalCount;
    }
}
