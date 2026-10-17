package Day07;

import java.util.ArrayList;

public class GenericDemo {

    // TODO: 编写泛型方法 printList
    public static <T> void printList(ArrayList<T> list){
        for(T t : list){
            System.out.println(t);
        }
    }
    public static void main(String[] args) {

        // TODO: 创建字符串集合并添加两个姓名

        ArrayList<String> t1 = new ArrayList<>();
        t1.add("张三");
        t1.add("李四");

        // TODO: 创建整数集合并添加两个成绩

        ArrayList<Integer> t2 = new ArrayList<>();
        t2.add(90);
        t2.add(95);

        // TODO: 分别调用 printList

        printList(t1);
        printList(t2);

    }
}
