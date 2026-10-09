package Day02;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // 在这里完成练习
        HashMap<Integer,Integer> scors = new HashMap<>();

        scors.put(1001,90);
        scors.put(1002,85);
        scors.put(1003,95);

        System.out.println(scors.get(1002));

        scors.put(1001,98);

        scors.remove(1003);

        System.out.println(scors.size());


    }
}
/*
创建一个 HashMap<Integer, Integer>，完成：
        1. 添加成绩：1001 → 90、1002 → 85、1003 → 95。
        2. 查询并打印 1002 的成绩。
        3. 修改 1001 的成绩为 98。
        4. 删除 1003。
        5. 打印集合中剩余的学生数量。*/
