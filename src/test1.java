import java.util.HashMap;
import java.util.Map;

public class test1 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 2, 4, 4};

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num : nums){
            if(map.containsKey(num)){
                map.put(num,map.get(num) + 1);
            }else{
                map.put(num,1);
            }
        }

        System.out.println(map);


        String[] words = {"java", "python", "java", "go", "python", "java"};

        System.out.println(countWords(words));
    }


    public static Map<String, Integer> countWords(String[] words) {
        Map<String, Integer> map = new HashMap<>();

        // TODO：把你已经通过验收的统计循环放到这里

        for(String word : words){
            if(map.containsKey(word)){
                map.put(word, map.get(word) + 1);
            }else {
                map.put(word,1);
            }
        }
        // TODO：返回统计结果
        return map;

    }

}
