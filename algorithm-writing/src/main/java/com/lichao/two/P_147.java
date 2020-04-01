package com.lichao.two;

/**
 * @Author: lichao
 * @Date: 2020-03-19 19:38
 */
class P_147 {

    // 4->2->1->3
    // 4 2
    public static ListNode insertionSortList(ListNode head) {


        if (head == null) {
            return null;
        }
        ListNode end = head.next;
        ListNode revert = head;
        head.next = null;


        while (end != null) {
            ListNode current = end;
            end = end.next;
            current.next = null;

            if (revert.val > current.val) {
                current.next = revert;
                revert = current;
                continue;
            } else {
                ListNode first = revert;
                ListNode second = revert.next;
                boolean success = false;
                while (second != null) {
                    if (second.val >= current.val) {
                        first.next = current;
                        current.next = second;
                        success = true;
                        break;
                    }
                    second = second.next;
                    first = first.next;
                }
                if (!success) {
                    first.next = current;
                }
            }


        }
        return revert;
    }





    public static class ListNode {
        int val;

        ListNode next;




        ListNode(int x) {
            val = x;
        }
    }




    public static void main(String[] args) {
        ListNode input = new ListNode(4);
        input.next = new ListNode(2);
        input.next.next = new ListNode(1);
        input.next.next.next = new ListNode(3);
        ListNode ret = insertionSortList(input);
        System.console().readLine();
    }
}