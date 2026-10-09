package Day02;

import java.util.HashMap;

public class Main1 {
    public static void main(String[] args) {
        HashMap<Integer, String> students = new HashMap<>();
        students.put(1001, "张三");
        students.put(1002, "李四");

        // 请从这里开始写
        if(students.containsKey(1001)){
            System.out.println("添加失败，学号已存在");
        }else{
            students.put(1001,"王五");
            System.out.println("添加成功");
        }

        System.out.println(students.get(1001));

    }
}

