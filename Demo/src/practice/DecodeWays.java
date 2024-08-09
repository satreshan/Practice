package practice;

import javax.sound.midi.Soundbank;
import java.util.List;

public class DecodeWays {
    public static int numDecodings(String s) {
        StringBuilder sb = new StringBuilder();

        List<Character> suffix = List.of('0','1','2','3','4','5','6');
        int[] dp = new int[s.length() + 1];
        int i = s.length() - 1;
        for(int j = 0; j<s.length() + 1; j++){
            dp[j] = 1;
        }
        //dp[s.length()] = 0;
        /*
        if(s.length() > 0 && s.charAt(0) == '0'){
            dp[0] = 0;
        }
        if(s.length() > 0 && s.charAt(s.length() - 1) == '0'){
            dp[s.length() - 1] = 0;
        } */
        while(i >= 0){
            if(s.charAt(i) == '0')
                dp[i] = 0;
            else
                dp[i] = dp[i+1];
            if(i + 1 < s.length() && (s.charAt(i) == '1' || (s.charAt(i) == '2' && "0123456".contains(Character.toString(s.charAt(i+1)))))){
                dp[i] += dp[i+2];
            }
            i--;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        String s = "11012";
        System.out.println(numDecodings(s));
    }
}
