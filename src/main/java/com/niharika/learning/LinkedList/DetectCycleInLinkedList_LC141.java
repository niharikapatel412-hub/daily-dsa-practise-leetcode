package com.niharika.learning.LinkedList;

import java.util.List;

public class DetectCycleInLinkedList_LC141 {
    public static void main(String[] args) {

        //Sample Test Case 1
        //Input : head = [3,2,0,-4], pos = 1
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;
        System.out.println(hasCycle(head));


        //Sample Test Case 2
        //Input : head = [1,2], pos = 0
        ListNode head2 = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = head.next;
        System.out.println(hasCycle(head2));


    }


    private static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if(head == null){

            return false;
        }
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
