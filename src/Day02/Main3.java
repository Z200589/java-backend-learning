package Day02;

import java.util.HashSet;

public class Main3 {
    public static void main(String[] args) {
        HashSet<Integer> users = new HashSet<>();

        // 1. 添加访问记录

        users.add(1001);
        users.add(1002);
        users.add(1003);
        users.add(1001);
        users.add(1004);
        users.add(1002);
        users.add(1005);

        // 2. 输出不同用户数量

        System.out.println("不同用户数量为：" + users.size());

        // 3. 判断用户1003是否存在

        System.out.println(users.contains(1003));

        // 4. 删除用户1004

        users.remove(1004);

        // 5. 遍历输出剩余用户ID

        for(Integer user : users){
            System.out.println(user);
        }

    }
}