package Day03;

import Day01.Student;

import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {
    public static void main(String[] args) {
        Student s1 = new Student(1001,"张三",90);
        Student s2 = new Student(1001,"张三",90);

        Set<Student> students = new HashSet<>();

        students.add(s1);
        students.add(s2);

        System.out.println(students.size());
    }
}
