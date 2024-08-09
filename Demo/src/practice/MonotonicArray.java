package practice;

public class MonotonicArray {
    public boolean isMonotonic(int[] nums) {
        int len = nums.length;
        boolean ans = true;
        int i = 1, j = 1;
        if (len == 1) {
            return ans;
        }
        for (int k = 1; k < len; k++) {
            if (nums[i] >= nums[i - 1]) {
                i++;
            }
            if (nums[j] <= nums[j - 1]) {
                j++;
            }
        }
        return i == len || j == len ? true : false;
    }

    public static void main(String[] args) {
        System.out.println(new MonotonicArray().isMonotonic(new int[]{1,1,0}));
    }
}
