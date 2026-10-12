package Day03;

import Day1.Student;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

    public static void main(String[] args) {


        //你的代码写这里

        Map<Integer, Student> students = new HashMap<>();
        students.put(1001, new Student(1001, "张三", 92));
        students.put(1002, new Student(1002, "李四", 85));
        students.put(1003, new Student(1003, "王五", 78));
        System.out.println(students.get(1002));
        students.put(1003, new Student(1003, "赵六", 95));
        students.remove(1001);
        System.out.println(students);

    }

}