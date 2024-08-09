package practice;

import java.util.ArrayList;
import java.util.List;

class MyLinkedList {

    ListNode head;
    int length;

    public MyLinkedList() {
        this.head = null;
        this.length = 0;
    }

    public int get(int index) {
        int len = length;
        int currIndex = 0;
        ListNode currPtr = head;
        if(index > length - 1){
            return -1;
        }
        while(currPtr != null && currIndex != index){
            currPtr = currPtr.next;
            currIndex++;
        }
        if(currPtr != null){
            return currPtr.val;
        }
        return -1;
    }

    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val, null);
        newNode.next = head;
        head = newNode;
        length++;
    }

    public void addAtTail(int val) {
        ListNode currPtr = head;
        //if empty list
        if(currPtr == null){
            ListNode newNode = new ListNode(val, null);
            head = newNode;
        }else {
            while(currPtr != null && currPtr.next != null){
                currPtr = currPtr.next;
            }
            ListNode newNode = new ListNode(val, null);
            currPtr.next = newNode;
        }
        length++;
    }

    public void addAtIndex(int index, int val) {
        int len = length;
        int currIndex = 0;
        ListNode currPtr = head;
        ListNode prevPtr = null;
        if(index > length){
            return;
        }else if(index == 0){
            //adding at head
            addAtHead(val);
        }else if(index == length){
            //adding at tail
            addAtTail(val);
        }else{
            //adding in middle
            while(currPtr != null && currIndex != index){
                prevPtr = currPtr;
                currPtr = currPtr.next;
                currIndex++;
            }
            ListNode newNode = new ListNode(val, null);
            newNode.next = currPtr;
            prevPtr.next = newNode;
        }
        length++;
    }

    public void deleteAtIndex(int index) {
        if(head == null || index >= length){
            return;
        }else if(index == 0 ){
            //delete head
            head = head.next;
        }else{
            //delete tail || middle
            ListNode currPtr = head;
            ListNode prevPtr = null;
            int currIndex = 0;
            while(currPtr != null && currPtr.next!=null && currIndex < index){
                prevPtr = currPtr;
                currPtr = currPtr.next;
                currIndex++;
            }
            prevPtr.next = currPtr.next;
        }
        length--;
    }
}

class ListNode {
    public int val;
    public ListNode next;
    public ListNode(){}
    public ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);

 1-> 3
 2
 */
public class LinkedListDesign {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        MyLinkedList ll = new MyLinkedList();
        //int param_1 = ll.get(1);
        ll.addAtHead(1);
        ll.addAtTail(3);
        ll.addAtIndex(1,2);
        System.out.println(ll.get(1));
        ll.deleteAtIndex(1);
        System.out.println(ll.get(1));
    }
}
