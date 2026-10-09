package Day02;

import java.util.HashSet;

public class Main4 {
    public static void main(String[] args) {
        int[] logins = {1001, 1002, 1003, 1001, 1004, 1002, 1005, 1003};
        HashSet<Integer> users = new HashSet<>();

        // 遍历 logins 数组

        int count = 0;
       /* for (int i = 0; i < logins.length; i++) {
            if(!users.contains(logins[i])){
                users.add(logins[i]);
                count++;
            }else {
                System.out.println("用户" + logins[i] + "重复登录");
            }
        }*/


        for(int login : logins){
            if(users.add(login)) count++;
            System.out.println("用户" + login + "重复登录");

        }
        System.out.println("不同用户总数：" + count);




        // 判断用户是否重复登录

        // 输出不同用户总数

    }
}