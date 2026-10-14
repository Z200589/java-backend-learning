package Day05;

import Day04.Student;

public class Test {
    public static void main(String[] args) {

        StudentService service = new StudentService();

        Student s1 = new Student(1001, "张三", 20);
        Student s2 = new Student(1001, "李四", 21);

        // 测试1：正常添加 s1
        // 打印 addStudent 的返回值

        System.out.println(service.addStudent(s1));

        // 测试2：添加 null
        // 使用 try-catch 捕获 IllegalArgumentException
        // 使用 e.getMessage() 输出异常信息

        try{
            service.addStudent(null);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        // 测试3：添加重复学号的 s2
        // 使用独立的 try-catch 捕获异常

        try {
            service.addStudent(s2);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        // 测试4：验证原来的学生是否被覆盖
        // 使用 findStudentById(1001) 查询并打印

        System.out.println(service.findStudentById(1001));


        System.out.println("测试结束");
    }
}