package algorithm.leecode.link;

import algorithm.util.ListNode;

public class Solution203 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;

        ListNode head = removeElements(l1, 2);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode removeElements(ListNode head, int val) {
        // 头节点值不能为val
        while (head != null && head.val == val) {
            head = head.next;
        }

        // 没有节点
        if (head == null) return null;
        // pre 下一个应该连接的节点，val ！= val
        ListNode curr = head.next, pre = head;
        while (curr != null) {
            if (curr.val == val) {
                // 跳过curr节点
                pre.next = curr.next;
            } else {
                // 不跳过，即等于curr节点
                pre = curr;
            }
            curr = curr.next;
        }
        return head;
    }
}
