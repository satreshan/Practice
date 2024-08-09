package practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        int maxFreq = 0;
        String[] words = paragraph.split("\\s");
        Set<String> bannedSet = new HashSet<>();
        Map<String, Integer> wordFreq = new HashMap<>();
        Arrays.stream(banned).forEach((w) -> bannedSet.add(w.toLowerCase()));
        String ans = null;
        for(String word : words){
            Integer currFreq = wordFreq.get(word);
            word = word.toLowerCase();
            if(!bannedSet.contains(word)){
                if(currFreq == null){
                    wordFreq.put(word, 1);
                }else{
                    wordFreq.put(word, ++currFreq);
                    if(maxFreq < currFreq){
                        maxFreq = currFreq;
                        ans = word;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String par = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        System.out.println(new MostCommonWord().mostCommonWord(par, banned));
    }
}
