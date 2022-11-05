package algorithm.leecode;

public class Solution2 {

    public class ListNode {
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, next = null;
        int remain = 0;
        while (l1 != null || l2 != null || remain != 0) {
            int l1Value = l1 == null ? 0 : l1.val;
            int l2Value = l2 == null ? 0 : l2.val;

            remain = l1Value + l2Value + remain;
            ListNode tmp = new ListNode(remain >= 10 ? remain % 10 : remain);
            remain = remain >= 10 ? remain / 10 : 0;

            if (head == null) {
                head = tmp;
                next = head;
            } else {
                next.next = tmp;
                next = tmp;
            }

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return head;
    }
}
