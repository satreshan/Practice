package practice;

import java.util.Stack;

public class DecodeString {

    public String decodeString(String s) {
        int len = s.length();
        String ans = "";
        int i = 0;

        java.util.Stack<Character> charStack = new java.util.Stack<>();
        java.util.Stack<Character> intStack = new Stack<>();
        while (i < len) {
            char currChar = s.charAt(i);
            if (currChar >= '0' && currChar <= '9') {
                intStack.push(currChar);
            } else if (currChar == '[') {
                intStack.push(currChar);
                charStack.push(currChar);
            } else if ((currChar >= 'a' && currChar <= 'z')) {
                if(intStack.isEmpty()){
                    ans += currChar;
                }else
                    charStack.push(currChar);
            } else {
                //if ']'
                String stackChar = "";
                String subS = "";
                while (!charStack.isEmpty()) {
                    int repeatNum = intStack.pop();
                    char c = charStack.pop();
                    while (c != '[') {
                        stackChar = c + stackChar;
                        c = charStack.pop();
                    }

                    while (repeatNum != 0) {
                        subS += stackChar;
                        repeatNum--;
                    }
                    if (!charStack.isEmpty()) {
                        for(char ch :subS.toCharArray()){
                            charStack.push(ch);

                        }
                        stackChar = "";
                        subS = "";
                    } else {
                        ans += subS;
                    }
                }

            } i++;
        }
        String subS = "";
        while (!charStack.isEmpty()) {
            subS = charStack.pop() + subS;
        }
        return ans + subS;
    }

    public static void main(String[] args) {
        String s = "100[leet]";
        System.out.println(new DecodeString().decodeString(s));
    }

}
