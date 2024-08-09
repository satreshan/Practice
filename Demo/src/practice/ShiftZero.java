package practice;

import java.util.Arrays;

public class ShiftZero {
    static int[] shiftZero(int[] arr){
        int i =0;
        int j =0;
        while(i < arr.length && arr[i] != 0){
            i++;
        }
        j = i+1;
        while(j < arr.length){
                if(arr[j] != 0){
                    arr[i] = arr[j];
                    arr[j] = 0;
                    i++;
                }
                j++;
        }
        return arr;
    }

    public static void main(String[] args) {
        Arrays.stream(shiftZero(new int[]{1,0,3,9,0,5})).forEach(System.out::print);
    }
}
