package practice;

import java.util.HashMap;

public class MergeKLinkedList {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;
        return mergeLists(lists, 0, lists.length - 1);
    }

    public ListNode mergeLists(ListNode[] lists, int start, int end) {
        int mid;
        if(start == end){
            return lists[start];
        }else if(end - start == 1){
            return merge(lists[start], lists[end]);
        }else {
            mid = start + (end - start)/2;
            //call first half of the list
            ListNode firstHalf = mergeLists(lists, start, mid);
            //call second half of the list
            ListNode secondHalf = mergeLists(lists, mid+1, end);

            //Merge two results
            return merge(firstHalf, secondHalf);
        }
    }

    public ListNode merge(ListNode list1, ListNode list2){
        ListNode current1 = list1;
        ListNode current2 = list2;
        ListNode mergedList = null;
        ListNode mergedListHead = null;

        while(current1 != null && current2 != null){
            if(current1.val < current2.val){
                ListNode next = current1.next;
                //current1.next = null;
                if(mergedList == null){
                    mergedList = mergedListHead = current1;
                }else{
                    mergedList.next = current1;
                    mergedList = mergedList.next;
                }
                current1 = next;
            }else{
                ListNode next = current2.next;
                //current2.next = null;
                if(mergedList == null){
                    mergedList = mergedListHead = current2;
                }else{
                    mergedList.next = current2;
                    mergedList = mergedList.next;
                }
                current2 = next;
            }
        }
        mergedList.next = current1 != null ? current1 : current2;
        return mergedListHead;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(4, new ListNode(5, null)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));
        ListNode list3 = new ListNode(2, new ListNode(6, null));
        ListNode res = new MergeKLinkedList().mergeKLists(new ListNode[]{list1, list2, list3});
        System.out.println("Merged");
    }
}/*
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
*/
