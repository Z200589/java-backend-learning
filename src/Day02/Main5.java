package Day02;

import java.util.HashSet;

public class Main5 {
    public static void main(String[] args) {

        HashSet<Student> students = new HashSet<>();

        // TODO: 添加五名学生

        students.add(new Student(1001, "张三"));
        students.add(new Student(1002, "李四"));
        students.add(new Student(1001, "张三"));
        students.add(new Student(1003, "王五"));
        students.add(new Student(1002, "赵六"));


        // TODO: 输出去重后的学生数量

        System.out.println("去重后的学生数量为：" + students.size());

        // TODO: 遍历并输出学生信息

        for(Student stu : students){
            System.out.println(stu.getId() + " : " + stu.getName());
        }


    }
}