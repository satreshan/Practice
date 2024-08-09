package practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BinaryHeap {
    int[] heap;
    int N;
    int capacity;
    public BinaryHeap(int capacity){
        heap = new int[capacity+1];
        this.capacity = capacity;
        N = 0;
    }
    List<Integer> ints = new ArrayList<>();

    private void swim(int k){
        while (k > 1 && heap[k] > heap[k/2]){
            exch(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k){
        int max = 0;
        while (k <= N/2){
            int i = heap[2 * k] > heap[2 * k + 1] ? 2 * k : 2 * k +1;
            if(heap[k] > heap[i]) break;;
            exch(k, i);
            k = i;
        }
    }


    private void exch(int i, int j){
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    public void insert(int val){
        if(N < capacity){
            heap[++N] = val;
            swim(N);
        }
    }
    public boolean isEmpty(){
        return N==0;
    }

    public int deleteMax(){

        int res = 0;
        if(!isEmpty()){
            exch(1, N);
            sink(1);
            res = heap[N--];
        }
        return res;
    }
}
