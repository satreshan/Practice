package practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountWord {
    public static void count(String s){
        String[] words = s.split("\\ ");
        Map<String, Integer> seen= new HashMap<>();
        Set<Integer> d = new HashSet<>();
        for (String str: words
             ) {
            if(!seen.containsKey(str)){
                seen.put(str, 1);
            }else{
                seen.put(str, seen.get(str) + 1);
            }
        }
        //Print seen
        System.out.println(seen);
    }
    //String s = "This is paragraph to count distinct words and print words to console";
    public static void main(String[] args) {
        CountWord.count("This is paragraph to count distinct words and print words to console");
    }
}
