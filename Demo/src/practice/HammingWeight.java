package practice;

public class HammingWeight {
    public static int hammingWeight(int n) {
        int hammingWeight = 0;

        while(n != 0){
            hammingWeight += (n % 10);
            n = n / 10;
        }
        return hammingWeight;
    }

    public static void main(String[] args) {
        int n = 10110000;
        int ans = 0;
        String s = Integer.toString(n);
        for(char c : s.toCharArray()){
            if(c == '1')
                ans++;
        }
        System.out.println(ans);

        System.out.println("Using mod function: " + hammingWeight(n));
        //int[] a=new int[10];

    }

}
