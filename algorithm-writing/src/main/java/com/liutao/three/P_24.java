package com.liutao.three;


/**
 * Author liutao
 * Date 2020/4/7 7:38 下午
 * Description:
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
 * Version: 1.0
 **/
public class P_24 {


    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node.next = node2;
        node2.next = node3;

        print( new P_24().swapPairs(node));

    }

    private static void print(ListNode head) {
        System.out.println();
        System.out.println("=======");
        System.out.print(head.val + "==");
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
            System.out.print(cur.val + "**");
        }
        System.out.println();
        System.out.println("=======");
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = new ListNode(1); //初始化pre
        pre.next=head;
        ListNode prev = pre; //指针
        ListNode curr = head;
        while (curr != null && curr.next != null) {

            //但索引为偶数的时候做交换

            ListNode a = curr;
            ListNode b = curr.next;
            prev.next = b;
            a.next = b.next;
            b.next = a;

            prev = a;

            curr = curr.next;


        }

        return pre.next;
    }


}
