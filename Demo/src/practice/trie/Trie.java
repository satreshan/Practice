package practice.trie;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Trie {
    static class Node{
        Node children[];
        boolean eow;

        public Node(){
            children = new Node[26];
            eow = false;
            for(int i = 0; i< 26; i++){
                children[i] = null;
            }
        }
    }
    static Node root = new Node();

    static void insert(String word){
        Node curr = root;

        for(int i =0; i< word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            if(i == word.length() - 1){
                curr.children[idx].eow = true;
            }
            curr = curr.children[idx];
        }
    }

    static boolean search(String key){
        Node curr = root;
        if(key == null || key.isEmpty()){
            return true;
        }else{
            for(int i =0; i< key.length(); i++){
                int idx = key.charAt(i) - 'a';
                if(curr.children[idx] == null){
                    return false;
                }
                if(i == key.length() -1){
                    return curr.children[idx].eow;
                }
                curr = curr.children[idx];
            }
        }
        return false;
    }

    //ilikesamsung---> wordbreak
    static boolean findValidWordInStatementExistInTrie(String statement){
        if(statement.isEmpty()){
            return true;
        }
        for(int i=1; i< statement.length()+1; i++){
            String first = statement.substring(0, i);
            String second = statement.substring(i,statement.length());

            if(search(first) && findValidWordInStatementExistInTrie(second)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Node curr = null;


        System.out.println("Stack operations");
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(12);
        stack.push(11);
        System.out.println("Pop 11:" + stack.pop());
        System.out.println("Peek 12:" + stack.peek());
        System.out.println("Pop 12:" + stack.pop());
        System.out.println("Pop 10:" + stack.pop());
        //Print empty string
        System.out.println("When trie is empty:");
        for(int i =0; i<26; i++){
            curr = root.children[i];
        }
        if(curr == null){
            System.out.println("<>");
        }
        String words[] = {"apple", "i", "like", "any", "app", "samsung"};
        for(int i =0; i< words.length; i++){
            insert(words[i]);
        }
        System.out.println("Is word app exists:" + search("app"));
        System.out.println("Is word apy exists:" + search("apply"));
        System.out.println("Is  empty str exists:" + search(""));

        System.out.println("Is statement ilikesamsung has valid words from dict:" + findValidWordInStatementExistInTrie("ilikesamsu"));


    }
}
