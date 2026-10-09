package Day02;

import java.util.HashMap;
import java.util.Map;

public class Main2 {
    public static void main(String[] args) {
        HashMap<Integer, Integer> scores = new HashMap<>();

        // 1. 添加五名学生成绩
        scores.put(1001, 90);
        scores.put(1002, 75);
        scores.put(1003, 58);
        scores.put(1004, 95);
        scores.put(1005, 62);

        double count = 0;
        double sum = 0;

        // 2. 使用 entrySet 遍历
        for(Map.Entry<Integer,Integer> entry : scores.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
            if(entry.getValue() >= 60){
                count++;
            }
            sum += entry.getValue();
        }


        // 3. 统计及格人数

        System.out.println("及格人数为：" + count);

        // 4. 计算平均成绩

        System.out.println("平均成绩为：" + sum / scores.size());
    }
}