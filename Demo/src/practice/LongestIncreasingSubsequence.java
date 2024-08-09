package practice;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
        int[] LIS = new int[nums.length];

        Arrays.fill(LIS, 1);
        int i = nums.length - 1;
        int maxLength = 0;
        for(int k = 0; k<nums.length; k++){
            LIS[k] = 1;
        }
        while(i >=0){
            int j = i + 1;
            while(j < nums.length ){
                if(nums[j] > nums[i]){
                    LIS[i] = Math.max(LIS[i], 1 + LIS[j]);
                }
                j++;
            }
            maxLength = Math.max(maxLength, LIS[i]);
            i--;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {0};
        System.out.println(lengthOfLIS(nums));
    }
}
