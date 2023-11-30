package algorithm.leecode.arr;

import algorithm.util.ListNode;

public class Solution206 {

    public static ListNode reverseList(ListNode head) {
        // 1. 递归终止条件
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return result;
    }

    public static ListNode reverseList2(ListNode head) {
        ListNode pre = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;

        ListNode result = reverseList3(l1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode reverseList3(ListNode head) {
        ListNode pre = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
