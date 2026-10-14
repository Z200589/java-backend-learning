package Day06;

import Day04.Student;

public class Test {
    public static void main(String[] args) {
        // 在这里独立完成练习3
      /*  在 Day06 包中新建 Test.java，使用 main 方法完成以下操作：
        1. 创建 StudentService 对象。
        2. 创建一个学号为 1001、姓名为张三、年龄为20的学生。
        3. 第一次调用 addStudent()，正常添加学生。
        4. 再创建一个学号同样为 1001 的学生，尝试重复添加。
        5. 使用 try-catch 捕获 StudentAlreadyExistsException，打印异常信息。
        6. 最后打印 "程序继续执行"。*/

        StudentService studentService = new StudentService();
        Student s1 = new Student(1001, "张三", 20);
        try{
            System.out.println(studentService.addStudent(s1));
        }catch(StudentAlreadyExistsException e){
            System.out.println(e.getMessage());
        }

        Student s2 = new Student(1001,"李四",19);
        try{
            studentService.addStudent(s2);
        }catch(StudentAlreadyExistsException e){
            System.out.println(e.getMessage());
        }

        System.out.println("程序继续执行");

    }
}