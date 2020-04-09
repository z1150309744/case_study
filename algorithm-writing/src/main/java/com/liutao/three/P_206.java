package com.liutao.three;

/**
 * Author liutao
 * Date 2020/4/7 7:33 下午
 * Description: 反转链表
 * Version: 1.0
 **/
public class P_206 {

    /**
     * 反转一个单链表。
     * <p>
     * 示例:
     * <p>
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     * 进阶:
     * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-linked-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
     ListNode nodeHead = new ListNode(head.val);
        nodeHead.next = null;
        ListNode newHead = null;
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
            newHead = new ListNode(cur.val);
            newHead.next = nodeHead;
            nodeHead = newHead;
        }
        return nodeHead;
    }

    public static ListNode reverseList1(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }



}
