package algorithm.leecode.common;

public class Solution21 {
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

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while (list1 != null || list2 != null) {
            int value1 = list1 == null ? 101 : list1.val;
            int value2 = list2 == null ? 101 : list2.val;
            ListNode node = new ListNode(Math.min(value1, value2));
            curr.next = node;
            curr = node;
            if (value1 < value2) {
                list1 = list1.next;
            } else {
                list2 = list2.next;
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;

        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(4);
        l4.next = l5;
        l5.next = l6;

        ListNode head = mergeTwoLists(l1, l4);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
