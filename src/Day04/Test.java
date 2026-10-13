package Day04;

public class Test {
    public static void main(String[] args) {
        Student student = new Student(1001,"张三",20);
        Student student1 = new Student(1002,"wangwu",30);

        StudentService studentService = new StudentService();
        System.out.println(studentService.addStudent(student));
        System.out.println(studentService.addStudent(student1));

        System.out.println(studentService.findStudentById(1001));

        System.out.println(studentService.updateStudent(new Student(1001,"李四",50)));

        System.out.println(studentService.deleteStudent(1001));
    }
}
