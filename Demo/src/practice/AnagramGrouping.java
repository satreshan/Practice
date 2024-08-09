package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramGrouping {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> dict = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for (String s : strs) {
            int i = 0;
            int[] count = new int[26];
            while (i < s.length()) {
                count['z' - s.charAt(i)] += 1;
                i++;
            }
            String sKey = Arrays.toString(count);
            //System.out.println(sKey);
            List<String> strList = dict.get(sKey);
            if (strList == null) {
                strList = new ArrayList<>();
                strList.add(s);
                dict.put(sKey, strList);
            } else {
                strList.add(s);
                dict.put(sKey, strList);
            }
        }
        for (Map.Entry<String, List<String>> anagrams : dict.entrySet()) {
            res.add(anagrams.getValue());
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new AnagramGrouping().groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }
}
