package com.liutao.three;


/**
 * Author liutao
 * Date 2020/4/7 9:12 下午
 * Description:
 * Version: 1.0
 **/
public class P_141 {
    /**
     * 给定一个链表，判断链表中是否有环。
     * <p>
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：head = [3,2,0,-4], pos = 1
     * 输出：true
     * 解释：链表中有一个环，其尾部连接到第二个节点。
     * <p>
     * <p>
     * 示例 2：
     * <p>
     * 输入：head = [1,2], pos = 0
     * 输出：true
     * 解释：链表中有一个环，其尾部连接到第一个节点。
     * <p>
     * <p>
     * 示例 3：
     * <p>
     * 输入：head = [1], pos = -1
     * 输出：false
     * 解释：链表中没有环。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/linked-list-cycle
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 =new ListNode(2);
       ListNode node3 = new ListNode(3);
       ListNode node4 = new ListNode(4);
       ListNode node5 = new ListNode(5);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next= node5;
        node5.next=node3;
        System.out.println(new P_141().hasCycle(node));


    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fastNode=head.next;
        ListNode lowNode= head;
        while (fastNode!=lowNode){
            if (fastNode == null || fastNode.next == null) {
                return false;
            }
            fastNode=fastNode.next.next;
            lowNode=lowNode.next;
        }
        return true;
    }


}
