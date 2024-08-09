package practice;

import java.util.Arrays;

public class SortColor {

    public void sortColors(int[] nums) {
        int i=-1;
        int j=nums.length;
        int k=0;
        if(nums.length == 0 || nums.length == 1) return;
        while(k < j && i < j ){
            if(nums[k] == 0){
                swap(nums, ++i, k);
                k++;
            }else if(nums[k] == 2){
                swap(nums, --j, k);
            }else
                k++;
        }
    }

    private void swap(int[] nums, int i, int k) {
        int temp = nums[i];
        nums[i] = nums[k];
        nums[k] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        SortColor sc = new SortColor();
        sc.sortColors(nums);
        Arrays.stream(nums).forEach(n -> System.out.println(n));
    }
}
