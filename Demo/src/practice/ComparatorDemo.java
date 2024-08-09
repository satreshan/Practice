package practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ComparatorDemo {
    int compareArray(int N, int[] num){
        int[][] a = {{1,4}, {0,0}};
        List<int[]> ll = Arrays.stream(a).sorted(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        }).collect(Collectors.toList());

        //List<int[]> l2 = Arrays.stream(a).sorted((a1, b1) -> a1[0] - b1[0]).collect(Collectors.toList());
        Iterator<int[]> iterator = ll.listIterator();
        while (iterator.hasNext()){
            Arrays.stream(iterator.next()).forEach(System.out::println);
        }
        return 0;
    }

    public static void main(String[] args) {
        ComparatorDemo gt = new ComparatorDemo();
        gt.compareArray(0,new int[]{});
    }
}
