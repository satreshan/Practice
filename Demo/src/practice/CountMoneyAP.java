package practice;

public class CountMoneyAP {
    public int totalMoney(int n) {
        int w = n/7;
        int d = n % 7;
        int j =1;
        int i;
        int ans = 28 * w;
        if(w > 1)
            ans += Float.valueOf(w/2.0f) * (7*(w-1));
        for(w++; j <= d; j++){
            ans += w++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new CountMoneyAP().totalMoney(26));
    }
}
