package com.dongyantong.two;

/**
 * @Author: dongyantong
 * @Date: 2020/4/5
 */
public class P_19 {
    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode fast = pre;
        ListNode last = pre;
        while (n != 0) {
            fast = fast.next;
            n--;
        }
        while (fast.next != null) {
            fast = fast.next;
            last = last.next;
        }
        last.next = last.next.next;
        return pre.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
