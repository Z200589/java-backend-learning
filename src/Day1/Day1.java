package Day1;

import java.util.ArrayList;
import java.util.List;

public class Day1 {
    public static void main(String[] args){
        List<String> student = new ArrayList<>();
        student.add("张三");
        student.add("李四");
        student.add("王五");
        student.add("赵六");
        student.remove(1);
        student.set(1,"钱七");
        for(int i = 0;i < student.size();i++){
            System.out.println(student.get(i));
        }
        System.out.println(student.size());

    }
}
