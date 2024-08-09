package practice;

public class Palindrome {
    public boolean isPalindrome(String s) {
        String newString = s.toLowerCase();
        int l = 0;
        int r = s.length() - 1;
        while(l<=r){
            char lc = newString.charAt(l);
            while(l<=r && !isAlphanumeric(lc)){
                l++;
                lc = newString.charAt(l);
            }
            char rc = newString.charAt(r);
            while(r >= l && !isAlphanumeric(rc)){
                r--;
                rc = newString.charAt(r);
            }
            if(lc == rc){
                l++;
                r--;
            }else{
                return false;
            }
        }
        return true;
    }

    boolean isAlphanumeric(char c){
        int number = '9' - c;
        int lowercase = 'z' - c;
        int uppercase = 'Z' - c;
        if((number >= 0 && number <=9) || (lowercase >=0 && lowercase < 26) || (uppercase >=0 && uppercase < 26) )
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        System.out.println(new Palindrome().isPalindrome("A man, a plan, a canal: Panama"));
    }
}
