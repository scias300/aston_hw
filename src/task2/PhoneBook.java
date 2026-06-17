package task2;

import java.util.*;

public class PhoneBook {
    private Map<String, List<String>> contacts = new HashMap<>();

    public void add(String lastName, String phoneNumber) {
        contacts.putIfAbsent(lastName, new ArrayList<>());
        contacts.get(lastName).add(phoneNumber);
    }

    public List<String> get(String lastName) {
        if (!contacts.containsKey(lastName)) {
            return new ArrayList<>();
        }
        return contacts.get(lastName);
    }

    public void printPhones(String lastName) {

        List<String> phones = get(lastName);

        if (phones.isEmpty()) {
            System.out.println("Фамилия " + lastName + " не найдена");
            return;
        }

        System.out.println(lastName + ": " + phones);
    }

    @Override
    public String toString() {
        return contacts.toString();
    }
}
