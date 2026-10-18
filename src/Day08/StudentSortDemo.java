
package Day08;

import Day04.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentSortDemo {
    public static void main(String[] args) {

        // 1. 创建学生集合
        List<Student> students = new ArrayList<>();

        // 2. 添加三个学生
        students.add(new Student(1001, "张三", 20));
        students.add(new Student(1002, "李四", 18));
        students.add(new Student(1003, "王五", 21));
        students.add(new Student(1004, "赵六", 20));
        students.add(new Student(1005, "钱七", 20));

        // 3. 使用 Comparator 按年龄升序排序
        students.sort((a, b) -> {
            // TODO：比较 a 和 b 的年龄
            // 提示：使用 a.getAge() 和 b.getAge()
            // 将下面的临时返回值改成正确的比较结果

            if(a.getAge() > b.getAge()){
                return 1;
            }else if(a.getAge() == b.getAge()){
                return 0;
            }else {
                return -1;
            }
        });

        // 4. 遍历排序后的集合
        for (Student student : students) {
            System.out.println(
                    student.getName() + " " + student.getAge()
            );
        }
    }
}
