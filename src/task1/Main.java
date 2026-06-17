package task1;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Vasia", "IT1", 2, new int[]{5, 4, 3, 4, 5});
        Student student2 = new Student("Masha", "ART2", 2, new int[]{5, 4, 3, 2, 5});
        Student student3 = new Student("Sasha", "IT1", 3, new int[]{2, 3, 3, 2, 3});
        Student student4 = new Student("Ira", "IT3", 1, new int[]{5, 4, 5, 5, 5});

        Set<Student> students = new HashSet<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        System.out.println(students);

        Student.removeStudentsWithLowAverage(students);

        System.out.println(students);

        Student.printStudents(students, 2);

        Student.nextCourse(students);

        System.out.println(students);
    }
}
