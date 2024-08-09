package practice;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstrWithoutRpeatingChar {

    int longestString(String str) {
        int ans = Integer.MIN_VALUE;
        int i = 0;
        int j = 0;
        Map<Character, Integer> cache = new HashMap<>();
        int len = str.length();
        while(j < len){
            Integer prevPos = cache.put(str.charAt(j), j);
            if(prevPos == null){
                j++;
                ans = Math.max(ans, j-i);
            }else{
                j++;
                i = Math.max(i,prevPos + 1);
                ans = Math.max(ans, j-i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "ABBDEFBGBABEF";
        System.out.println(new LongestSubstrWithoutRpeatingChar().longestString(str));
    }
}
