package practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Arrays.*;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % nums.length;
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    private void reverse(int a[], int s, int e){
        while(s<e){
            int t = a[s];
            a[s] = a[e];
            a[e] = t;
            s++;
            e--;
        }
    }

    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5,6,7};
        new RotateArray().rotate(nums,8);
        System.out.println(Arrays.toString(nums));
        List<Integer> integerList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        int[] toIntArray = integerList.stream().mapToInt(i -> i).toArray();
        System.out.println(IntStream.of(toIntArray).boxed().collect(Collectors.toList()));
        Random random = new Random();
        random.nextInt();
    }

}
