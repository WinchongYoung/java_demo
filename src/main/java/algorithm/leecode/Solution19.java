package algorithm.leecode;

public class Solution19 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode first = head, second = head;
        // 初始化第一个指针
        for (int i = 0; i < n; i++) {
            first = first == null ? null : first.next;
        }
        if (first == null) {
            return head.next;
        }
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }

        // 倒数第n - 1个节点为second
        second.next = second.next == null ? null : second.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        ListNode tmp = l1;
        tmp = tmp.next;
        System.out.println(l1.val);

        /*ListNode result = removeNthFromEnd(l1, 2);
        while (result != null) {
            // System.out.println(result.val);
            result = result.next;
        }*/

    }
}
