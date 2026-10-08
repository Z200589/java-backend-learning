package Day1;

import java.util.LinkedList;

public class QueuePractice {
    public static void main(String[] args) {

        LinkedList<String> queue = new LinkedList<>();

        // TODO 1：添加三名普通排队人员
        queue.add("张三");
        queue.add("李四");
        queue.add("王五");

        // TODO 2：赵六插入队首
        queue.addFirst("赵六");

        // TODO 3：钱七加入队尾
        queue.addLast("钱七");
        // TODO 4：输出当前队伍
        System.out.println(queue);
        // TODO 5：查看队首人员
        System.out.println(queue.getFirst());
        // TODO 6：让队首离开
        queue.removeFirst();
        // TODO 7：输出剩余队伍和人数
        System.out.println(queue);
        System.out.println(queue.size());
    }
}
