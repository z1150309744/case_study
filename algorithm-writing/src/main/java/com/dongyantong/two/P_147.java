package com.dongyantong.two;

/**
 * @Author: dongyantong
 * @Date: 2020/3/29
 */
public class P_147 {
    public static void main(String[] args) {

    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        dummy.next = head;
        ListNode curr = head;
        ListNode tail = dummy;
        while (curr != null) {
            if (tail.val < curr.val) {
                tail.next = curr;
                tail = curr;
                curr = curr.next;
            } else {
                ListNode node = dummy;
                while (node.next != null && node.next.val < curr.val) {
                    node = node.next;
                }
                ListNode temp = curr.next;
                curr.next = node.next;
                node.next = curr;
                curr = temp;
            }
        }
        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
