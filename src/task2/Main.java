package task2;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Ivanov", "88005553535");
        phoneBook.add("Ivanov", "1112221488");

        phoneBook.add("Petrov", "88002002316");

        System.out.println(phoneBook);
        phoneBook.printPhones("Ivanov");
        phoneBook.printPhones("Sidorov");
    }
}
