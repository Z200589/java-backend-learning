package Day07;

import Day04.Student;
import Day06.StudentAlreadyExistsException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentService {
    private static Map<Integer, Student> students;

    public StudentService(){
        students = new HashMap<>();
    }

    public boolean addStudent(Student student){
        /*打开 Day05/StudentService.java，先复制到 Day06 包中，作为今天的练习版本。
        在 Day06/StudentService.java 中找到 addStudent(Student student) 方法。
        保留原来的学生非空校验。
        当学生学号已经存在时，抛出你刚才创建的 StudentAlreadyExistsException。
        当学号不存在时，正常将学生加入 Map，返回 true。
        不要在 addStudent() 内部捕获并吞掉这个异常。*/
        if(student == null){
            throw new IllegalArgumentException("学生不能为空");
        }


        if(students.containsKey(student.getId())){
                throw new StudentAlreadyExistsException("学号已经存在");
        }

        students.put(student.getId(),student);

        return true;
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


    public ArrayList<Student> findByName(String keyword){

        ArrayList<Student> result = new ArrayList<>();

        if(keyword == null || keyword.isEmpty()){
            throw new IllegalArgumentException("搜索关键词不能为空");
        }

        for(Student student : students.values()){
            if(student.getName().contains(keyword)){
                result.add(student);
            }
        }

        return result;
    }

}
