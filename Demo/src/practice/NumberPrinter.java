package practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class NumberPrinter implements Runnable{
    int n;
    NumberPrinter(int number){
        n = number;
    }


    public static void main(String[] args ){
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new NumberPrinter(10));
        executorService.execute(new NumberPrinter(15));
        executorService.execute(new NumberPrinter(20));
        executorService.shutdown();
    }

    @Override
    public void run() {
        for (int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName() + " : Number: " + ++n);
        }
    }
}
