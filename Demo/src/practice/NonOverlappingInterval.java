package practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class NonOverlappingInterval {
    public int eraseOverlapIntervals(int[][] intervals) {
        //Sort the array and iterate over it one by one
        //chk if two are overlapping if yes remove the one wich ends later
        List<int[]> list = Arrays.stream(intervals).sorted(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0] - o2[0];
            }
        }).collect(Collectors.toList());
        int[] currentInterval = list.get(0);
        int len = intervals.length;
        int i = 1;
        int removed = 0;
        while(i < len){
            int[] nextInterval = list.get(i);
            if(nextInterval[0] < currentInterval[1]){
                removed += 1;
                if(nextInterval[1] < currentInterval[1]){
                    currentInterval = nextInterval;
                    i++;
                }
            }else{
                currentInterval = nextInterval;
            }
            i++;
        }
        return removed;
    }

    public static void main(String[] args) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[0] - b[0]));
        int[][] m = {{0,1},{3,4},{1,2}};
        System.out.println(new NonOverlappingInterval().eraseOverlapIntervals(m));
    }
}
