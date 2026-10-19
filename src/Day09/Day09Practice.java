package Day09;

import java.util.HashMap;
import java.util.Map;

public class Day09Practice {

    public static void main(String[] args) {
        Map<String, Integer> counts = new HashMap<>();

        countWord(counts, "java");
        countWord(counts, "spring");
        countWord(counts, "java");

        System.out.println(counts);
    }

    static void countWord(Map<String, Integer> counts, String word) {
        // TODO：在这里补全代码
        // 必须使用 getOrDefault()

        counts.put(word,counts.getOrDefault(word,0) + 1);
    }
}
