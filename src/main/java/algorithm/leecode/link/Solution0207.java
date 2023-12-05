package algorithm.leecode.link;

import algorithm.util.ListNode;

import java.util.HashMap;
import java.util.Map;

public class Solution0207 {

    // 解法1：:用map存储第一个链表结构，Map<hashCode, val>
    // 便利另一个链表，找出第一个hashCode val相等的节点即时第一个相交节点
    // 时间复杂度n,空间复杂度n,有优化空间
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        Map<Integer, Integer> map = new HashMap<>();
        while (a != null) {
            map.put(a.hashCode(), a.val);
            a = a.next;
        }
        while (b != null) {
            Integer hashCode = map.get(b.hashCode());
            if (hashCode != null && hashCode == b.val) {
                return b;
            }
            b = b.next;
        }
        return null;
    }

    // 双指针
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        /*
        总体思路:双指针
        headA=[a1,a2,...,an]与headB=[b1,b2,...,bn]
        pA在a1出发,pB在b1出发;当pA到达A链表末尾null就到B开头处重新开始;pB同理
        最后两个指针相遇时就是相交的地方
         */
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            // A指针与B一路往下走,走完了就去另一个链表的头结点,直至相遇
            // 这里注意不能用pA.next作为判断,因为遇到空链表会发生空指针异常
            // 这里就算有其中一个链表为空或者没相交的也成立(最后为null)
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        // pA==pB
        return pA;
    }

}
