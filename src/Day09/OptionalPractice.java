
package Day09;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalPractice {

    public static void main(String[] args) {
        Map<Integer, String> students = new HashMap<>();

        students.put(1001, "张三");
        students.put(1002, "李四");

        System.out.println(findStudent(students, 1001));
        System.out.println(findStudent(students, 9999));
    }

    static Optional<String> findStudent(
            Map<Integer, String> students, int id) {

        // TODO：使用 Optional.ofNullable()
        // 返回根据 id 查到的学生姓名

        return Optional.ofNullable(students.get(id));


    }
}
