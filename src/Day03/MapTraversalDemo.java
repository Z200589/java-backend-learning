package Day03;

import Day1.Student;

import java.util.HashMap;
import java.util.Map;

public class MapTraversalDemo {
    public static void main(String[] args) {
        Map<Integer,Student> students = new HashMap<>();
        students.put(1001, new Student(1001, "张三", 92));
        students.put(1002, new Student(1002, "李四", 85));
        for(Map.Entry<Integer,Student> entry : students.entrySet()){
            Integer id = entry.getKey();

            Student student = entry.getValue();

            System.out.println("学号：" + id + " 姓名：" + student.getName() + " 成绩:" + student.getScore());
        }
    }
}
