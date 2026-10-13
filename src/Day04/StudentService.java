package Day04;

import java.util.HashMap;
import java.util.Map;

public class StudentService {
    private Map<Integer,Student> students;

    public StudentService(){
        students = new HashMap<>();
    }

    public boolean addStudent(Student student){
        /*if(!students.containsKey(student.getId())){
            students.put(student.getId(),student);
            return true;
        }else{
            return false;
        }*/

        if(student == null){
            return false;
        }

        if(students.containsKey(student.getId())){
            return false;
        }

        students.put(student.getId(),student);

        return true;
    }

    public Student findStudentById(int id){
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
        if(students.containsKey(student.getId())){
            students.put(student.getId(),student);
            return true;
        }else{
            return false;
        }
    }

}
