package Day07;

import Day04.Student;
import Day07.StudentService;

import java.util.ArrayList;
import java.util.List;

public class StudentSearchTest {
    public static void main(String[] args) {
        StudentService service = new StudentService();

        // 1. 创建3个学生，调用 addStudent 添加

        Student s1 = new Student(1001, "张三", 20);
        Student s2 = new Student(1002, "张小明", 19);
        Student s3 = new Student(1003, "李四", 21);

        service.addStudent(s1);
        service.addStudent(s2);
        service.addStudent(s3);
        // 2. 测试关键词 "张"，遍历并输出匹配结果

        List<Student> result = service.findByName("张");
        if(!result.isEmpty()){
            for(Student student : result){
                System.out.println(student.getName());
            }
        }

        // 3. 测试关键词 "王"，检查是否返回空列表

        List<Student> result2 = service.findByName("王");
        if(!result2.isEmpty()){
            for(Student student : result2){
                System.out.println(student.getName());
            }
        }else {
            System.out.println("没有找到学生");
        }


        // 4. 测试空字符串 ""，捕获 IllegalArgumentException

        try{
            List<Student> result3 = service.findByName("");
            System.out.println("测试失败，未抛出预期异常");
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }
}
