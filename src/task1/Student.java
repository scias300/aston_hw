package task1;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

public class Student {
    private String name;
    private String group;
    private int course;
    private int[] grades;

    public Student(String name, String group, int course, int[] grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    public static void removeStudentsWithLowAverage(Set<Student> students) {
        Iterator<Student> iterator = students.iterator();

        while (iterator.hasNext()) {
            Student student = iterator.next();

            int sum = 0;
            for (int grade : student.grades) {
                sum += grade;
            }

            double avg = (double) sum / student.grades.length;

            if (avg < 3) {
                iterator.remove();
            }
        }
    }

    public static void nextCourse(Set<Student> students) {
        for (Student student : students) {
            int sum = 0;
            for (int grade : student.grades) {
                sum += grade;
            }
            double avg = (double) sum / student.grades.length;
            if (avg >= 3) {
                student.course++;
            }
        }
    }


    public static void printStudents(Set<Student> students, int course) {
        for (Student student : students) {
            if (student.course == course) {
                System.out.println(student.name + " " + student.course + " курс");
            }
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", course=" + course +
                ", grades=" + Arrays.toString(grades) +
                '}';
    }
}
