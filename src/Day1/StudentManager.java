
package Day1;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();

        // TODO 1：创建三个 Student 对象
        Student s1 = new Student(1001,"张三",92);
        Student s2 = new Student(1002,"李四",85);
        Student s3 = new Student(1003,"王五",78);



        // TODO 2：添加到 students 集合
        students.add(s1);
        students.add(s2);
        students.add(s3);


        int searchId = 1002;
        boolean found = false;
        int j = -1;
        for(int i = 0;i < students.size();i++){
            if(students.get(i).getId() == searchId){
                found = true;
                j = i;
                break;
            }
        }
        if (found){
            System.out.println(students.get(j));
        }else{
            System.out.println("未找到该学生");
        }
        // TODO 3：使用增强 for 循环遍历
        for(Student student : students){
            System.out.println(student);
        }


        // TODO 4：输出学生总人数

        System.out.println(students.size());

        int updateId = 1002;
        double newScore = 95;
        boolean find = false;
        int m = 0;
        for(int i = 0;i < students.size();i++){
            if(students.get(i).getId() == updateId){
                students.get(i).setScore(newScore);
                find = true;
                m = i;
                break;
            }
        }
        if(find){
            System.out.println(students.get(m));
        }else{
            System.out.println("修改失败，学生不存在");
        }

        int deleteId = 1003;
        boolean isFound = false;
        for(int i = 0;i < students.size();i++){
            if(students.get(i).getId() == deleteId){
                students.remove(i);
                isFound = true;
                break;
            }
        }
        if(isFound){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败，学生不存在");
        }

        System.out.println(students);
        System.out.println(students.size());

    }
}
