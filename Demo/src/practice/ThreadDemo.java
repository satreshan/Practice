package practice;

public class ThreadDemo implements Runnable{

    String s = "Shalini";
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println(s);
    }

    public static void main(String[] args) {
        Thread t = new Thread(new ThreadDemo());
        Thread t1 = new Thread(new ThreadDemo());
        System.out.println(Thread.currentThread().getName());
        t.start();
        t1.start();
        //t.run();
    }
}
