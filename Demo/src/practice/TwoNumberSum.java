package practice;

public class TwoNumberSum {
    public static int getSum(int a, int b) {
        while(b != 0){
            int tmp = a;
            a = a ^ b;
            b = tmp & b;
            if(b != 0){
                b = b<<1;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(getSum(1, 2));
    }
}
