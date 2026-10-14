package Day03;

import Day01.Student;

import java.util.*;

public class StudentManager {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        Student s1 = new Student(1, "张三", 90);
        Student s2 = new Student(2, "李四", 80);
        Student s3 = new Student(3, "王五", 75);
        students.add(s1);
        students.add(s2);
        students.add(s3);

        Map<Integer,Student> studentMap = new HashMap<>();
        studentMap.put(s1.getId(), s1);
        studentMap.put(s2.getId(), s2);
        studentMap.put(s3.getId(), s3);

        if(studentMap.containsKey(2)){
            System.out.println(studentMap.get(2));
        }else{
            System.out.println("没有找到该学生");
        }

        Student student = studentMap.get(2);
        student.setScore(95);

        Set<Student> studentSet = new HashSet<>();
        studentSet.add(s1);
        studentSet.add(s2);

        students.remove(s2);
        studentMap.remove(2);
        studentSet.remove(s2);



        System.out.println(studentSet);
    }
}
