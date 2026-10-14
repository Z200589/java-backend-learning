package Day05;

import Day04.Student;

import java.util.HashMap;
import java.util.Map;

public class StudentService {
    private static Map<Integer, Student> students;

    public StudentService(){
        students = new HashMap<>();
    }

    public static boolean addStudent(Student student){
        // TODO 1：如果 student 为 null
        // 主动抛出 IllegalArgumentException

        // TODO 2：如果学号已经存在
        // 主动抛出 IllegalArgumentException

        // TODO 3：将学生添加到 students 中

        // TODO 4：返回 true

        if(student == null){
            throw new IllegalArgumentException("学生不能为空");
        }else if(students.containsKey(student.getId())){
            throw new IllegalArgumentException("学号已经存在");
        }else {
            students.put(student.getId(),student);
            return true;
        }




    }

    public static Student findStudentById(int id){
       /* if(students.containsKey(id)){
            return  students.get(id);
        }else{
            return null;
        }*/

        return students.get(id);
    }

    public boolean deleteStudent(int id){
       /* if(students.containsKey(id)){
            students.remove(id);
            return true;
        }else{
            return false;
        }*/

        return students.remove(id) != null;
    }

    public boolean updateStudent(Student student){
        if(student == null){
            return false;
        }

        if(!students.containsKey(student.getId())){
            return false;
        }

        students.put(student.getId(),student);

        return true;
    }

}
